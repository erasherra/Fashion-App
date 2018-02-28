/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Auth;
import model.Contact;

/**
 *
 * @author Amir Ingher
 */
@Stateless
public class SessionBean {
    
    
    @PersistenceContext
    private EntityManager em;
    
    public Contact insert(Contact c) { 
        em.persist(c); 
        return c; 
    }
    
    
    public Auth SelectById(int id){
        
        return (Auth) em.createNamedQuery("Auth.findById").setParameter("id", id).getSingleResult();
    }
    
    
    
    public Auth checkPassword(String user) { 
        
        
         return (Auth) em.createNamedQuery("Auth.findPasswordById").setParameter("user", user).getSingleResult();
         
        
         
             
             
    }
    
    public void update(Contact c) { 
        em.merge(c);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
