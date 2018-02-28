/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import controller.SessionBean;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Auth;
import model.Contact;

/**
 * REST Web Service
 *
 * @author Amir Ingher
 */
@Path("Auth")
public class AuthResource {

    @EJB
    private SessionBean sb;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AuthResource
     */
    public AuthResource() {
    }

    /**
     * Retrieves representation of an instance of rest.AuthResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    
    
    @POST
    @Path("login")
    @Produces(MediaType.TEXT_HTML)
    public String postTextParam(@FormParam("pw") String pw, @FormParam("un") String un) {
        //TODO return proper representation object
        try{
        Auth a=sb.getByName(un);
        
        if(a.getPassword().equals(pw)){
            return "<div><h1><a href='http://10.114.32.54:8080/FashionApp/home.html'><p class='small'>Log in from here "+un+pw+"</p></a></h1></div>";
        }else{
            return "<h1>Username or password is wrong </h1>";
        }
        }catch(Exception e){}
        return "<h1>Username or password is wrong</h1>";
    }

    /**
     * PUT method for updating or creating an instance of AuthResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
