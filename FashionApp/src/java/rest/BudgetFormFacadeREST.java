/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import controller.LinkManager;
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
import model.BudgetForm;
import model.Form;
import model.Project;

/**
 *
 * @author saritakhanal
 */
@Stateless
@Path("model.budgetform")
public class BudgetFormFacadeREST extends AbstractFacade<BudgetForm> {
    @EJB
    private SessionBean sb;

    @PersistenceContext(unitName = "FashionAppPU")
    private EntityManager em;
    
    private LinkManager lm;

    public BudgetFormFacadeREST() {
        super(BudgetForm.class);
        
        LinkManager lm = new LinkManager();
    }

    @POST
    @Override
    @Consumes({ MediaType.APPLICATION_JSON})
    public void create(BudgetForm entity) {
        super.create(entity);
    }
    
    @POST
    @Path("{pId}/{FormId}/{ThemeId}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public void LinkToBudgetForm(@PathParam("pId") String Pid, @PathParam("FormId") Integer Fid, @PathParam("ThemeId") Integer Tid ) {
        
        BudgetForm bf = new BudgetForm();
        
        bf.setFormID(sb.SelectFormById(Fid));
        bf.setThemeID(sb.SelectThemesById(Tid));
        
        
        super.create(bf);
        
        Project p = sb.SelectByPName(Pid);
        
        p.setBudgetformID(bf);
                
        //lm.LinkBudgetToThemeAndForm(Bid, Fid, Tid);
    }

    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, BudgetForm entity) {
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
    public BudgetForm find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({ MediaType.APPLICATION_JSON})
    public List<BudgetForm> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<BudgetForm> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
