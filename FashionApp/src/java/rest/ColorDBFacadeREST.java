/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import controller.SessionBean;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Collection;
import model.Collectionholder;
import model.ColorDB;
import model.Project;

/**
 *
 * @author Amir Ingher
 */
@Stateless
@Path("model.colordb")
public class ColorDBFacadeREST extends AbstractFacade<ColorDB> {
    
        @EJB
    private SessionBean sb;


    @PersistenceContext(unitName = "FashionAppPU")
    private EntityManager em;

    public ColorDBFacadeREST() {
        super(ColorDB.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(ColorDB entity) {
        super.create(entity);
        
        
    }
    
    @POST
    @Path("{cname}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void createAndLinkToCollection(@PathParam("cname") String cname,ColorDB entity) {
        super.create(entity);
        
        Collection c = sb.SelectColllectionByName(cname);
        
        Project p = new Project();
        p.setName("project-"+c.getName());
        p.setColorId(entity);
        sb.insertProject(p);
        
        Collectionholder ch = new Collectionholder();
        ch.setCollectionID(c);
        ch.setProjectID(p);
        
        sb.insertCollectionholder(ch);
        
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, ColorDB entity) {
        super.edit(entity);
        
        
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public ColorDB find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
        @GET
    @Path("name/{colorName}")
    @Produces(MediaType.APPLICATION_JSON)
    public ColorDB findName(@PathParam("colorName") String colorName){
        ColorDB color = sb.findColorByName(colorName);
        return color;
    }


    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<ColorDB> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<ColorDB> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
