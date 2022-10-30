/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.personapp.ejb.beans.impl;

import co.edu.javeriana.personapp.ejb.beans.AbstractFacade;
import co.edu.javeriana.personapp.ejb.beans.PersonaFacadeLocal;
import co.edu.javeriana.personapp.ejb.entities.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author User
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> implements PersonaFacadeLocal {

    @PersistenceContext(unitName = "persona_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
    public List<Persona> getAll(){
        TypedQuery<Persona> query = em.createQuery("select p from persona p",Persona.class);
        return query.getResultList();
    }
}
