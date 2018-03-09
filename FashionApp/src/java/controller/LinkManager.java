/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.BudgetForm;
import model.Form;
import model.Project;
import model.Themes;

/**
 *
 * @author Amir Ingher
 */

public class LinkManager {
    @EJB
    private SessionBean sb;
    
    public LinkManager(){
        
        
    }
    
    public void LinkBudgetToThemeAndForm(Integer budget,Integer form, Integer theme){
        BudgetForm bf = new BudgetForm();
        
        bf.setFormID(sb.SelectFormById(form));
        bf.setThemeID(sb.SelectThemesById(theme));
        
        
        
    }
    
    public void CreateProject(String projectName){
       
        
        Project p = sb.SelectByPName(projectName);
        
        
        
        /*
        BudgetForm bf = new BudgetForm();
        
        sb.insertBF(bf);
        
        p.setBudgetformID(bf);
        */
        
        
        
    }
    
    
}
