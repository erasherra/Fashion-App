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
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Auth;

/**
 *
 * @author Joona Ikonen
 */
@Stateless
@Path("model.auth")
public class AuthFacadeREST extends AbstractFacade<Auth> {

    @EJB
    private SessionBean sb;
    
    
    @PersistenceContext(unitName = "FashionAppPU")
    private EntityManager em;

    public AuthFacadeREST() {
        super(Auth.class);
    }

    @POST
    @Override
    @Consumes({ MediaType.APPLICATION_JSON})
    public void create(Auth entity) {
        super.create(entity);
    }
    @POST
    @Path("login")
    @Produces(MediaType.TEXT_HTML)
    public String postTextParam(@FormParam("pw") String pw, @FormParam("un") String un) {
        //TODO return proper representation object
        try{
        Auth a=sb.getByName(un);
        
        if(a.getPassword().equals(pw)){
            return "<meta http-equiv=\"refresh\" content=\"0; URL='http://10.114.32.54:8080/FashionApp/home.html'\" />";
        }else{
            return "<h1>Username or password is wrong </h1>";
        }
        }catch(Exception e){}
        return "<h1>Username or password is wrong</h1>";
    }

    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Auth entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Auth find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Auth> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Auth> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
