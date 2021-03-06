/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Auth;
import model.BudgetForm;
import model.Collectionholder;
import model.ColorDB;
import model.Contact;
import model.Form;
import model.Project;
import model.Themes;
import model.Collection;

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
    
     
    
    
    ////////////////////////////////////////////collection
    
    
    public Collection SelectColllectionByName(String name){
        
        return (Collection) em.createNamedQuery("Collection.findByName").setParameter("name", name).getSingleResult();
        
        
    }
    
    public void insertCollection(Collection c) {
        em.persist(c);
        
    }
    
    
    //////////////////////////////////////////collectionholder
    
    
    
    public List<Collectionholder> getAllCollectionsWhatBelongsToCollection(int collectionID){
        
        return (List<Collectionholder>)em.createNamedQuery("Collectionholder.findByCollectionID").setParameter("collectionID", collectionID).getResultList();
    }
    
    
    public void insertCollectionholder(Collectionholder c) {
        em.persist(c);
        
    }
    
   
    
    //////////////////////////////////////////project
    public Project SelectByPName(String name){
        
        return (Project) em.createNamedQuery("Project.findByName").setParameter("name", name).getSingleResult();
    }
    
    public void insertProject(Project c) {
        em.persist(c);
        
    }
    
    
    
    public Project getByProjectId(int id){
        
        return (Project) em.createNamedQuery("Project.findById").setParameter("id", id).getSingleResult();
    }
    
    
    /////////////////////////////////////////budgetform
    
    public void insertBF(BudgetForm c) {
        em.persist(c);
        
    }
    
    public BudgetForm SelectBudgetById(int id){
        
        return (BudgetForm) em.createNamedQuery("BudgetForm.findById").setParameter("id", id).getSingleResult();
    }
    
    
    ///////////////////////////////////////////////Form
    
    public Form SelectFormById(int id){
        
        return (Form) em.createNamedQuery("Form.findById").setParameter("id", id).getSingleResult();
    }
    
    
    /////////////////////////////////////////////////themes
    
    public Themes SelectThemesById(int id){
        
        return (Themes) em.createNamedQuery("Themes.findById").setParameter("id", id).getSingleResult();
    }
    
    
    /////////////////////////////////////////////////////Auth
    public Auth getByName(String user) { 
        
         
         return (Auth) em.createNamedQuery("Auth.findPasswordById").setParameter("user", user).getSingleResult();
         
             
    }
    
    public Auth SelectById(int id){
        
        return (Auth) em.createNamedQuery("Auth.findById").setParameter("id", id).getSingleResult();
    }
    
    ///////////////////////////////////////////color
    public ColorDB findColorByName(String colorName){
        return (ColorDB) em.createNamedQuery("ColorDB.findByColorName").setParameter("colorName", colorName).getSingleResult();
     }
    
    public void update(Contact c) { 
        em.merge(c);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
