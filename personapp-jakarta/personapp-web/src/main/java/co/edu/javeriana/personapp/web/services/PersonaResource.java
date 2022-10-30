/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package co.edu.javeriana.personapp.web.services;

import co.edu.javeriana.as.jakarta.personapp.ejb.beans.impl.PersonaFacade;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author User
 */
@Path("persona")
@RequestScoped
public class PersonaResource {

    @Context
    private UriInfo context;
    private Gson gson;
    /**
     * Creates a new instance of PersonaResource
     */
    public PersonaResource() {
        gson = new Gson();
    }

    /**
     * Retrieves representation of an instance of co.edu.javeriana.personapp.web.services.PersonaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("getPersonas")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonas() {
        List<String> lista = new ArrayList<String>();
        lista.add("hola");
        lista.add("a");
        lista.add("getPersonas");
        return this.gson.toJson(lista);
    }

    /**
     * PUT method for updating or creating an instance of PersonaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
