/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package co.edu.javeriana.personapp.web.services;

import co.edu.javeriana.as.jakarta.personapp.ejb.beans.PersonaFacadeLocal;
import co.edu.javeriana.as.jakarta.personapp.ejb.entities.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.BeanParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author User
 */
@Path("persona")
@RequestScoped
public class GenericResource {

    @Context
    private UriInfo context;
    
    @EJB
    private PersonaFacadeLocal personaFacadeLocal;
    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of co.edu.javeriana.personapp.web.services.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("prueba")
    @Produces("text/html")
    public String getXml() {
        String lista = ""; 
        List<Persona> list = new ArrayList<Persona>();
        list = personaFacadeLocal.findAll();
        for(int i = 0; i < list.size();i++){
            lista += list.get(i).getNombre();
        }
        return "<h1> Algo " + lista +"</h1>";
        //throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
