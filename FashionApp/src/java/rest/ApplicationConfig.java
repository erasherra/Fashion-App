/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author Amir Ingher
 */
@javax.ws.rs.ApplicationPath("ws")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        resources.add(JacksonFeature.class);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(rest.AuthFacadeREST.class);
        resources.add(rest.BudgetFormFacadeREST.class);
        resources.add(rest.CardsFacadeREST.class);
        resources.add(rest.CollectionFacadeREST.class);
        resources.add(rest.CollectionholderFacadeREST.class);
        resources.add(rest.ColorDBFacadeREST.class);
        resources.add(rest.ContactFacadeREST.class);
        resources.add(rest.FormFacadeREST.class);
        resources.add(rest.MaterialCostFacadeREST.class);
        resources.add(rest.MaterialsFacadeREST.class);
        resources.add(rest.ProjectFacadeREST.class);
        resources.add(rest.SolutionCardFacadeREST.class);
        resources.add(rest.SubConCostTypesFacadeREST.class);
        resources.add(rest.SubcostFacadeREST.class);
        resources.add(rest.ThemesFacadeREST.class);
    }
    
}
