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
    
    //void create(Persona persona);

    @Override
    public void create(Persona persona)
    {
        TypedQuery<Persona> query = em.createQuery("INSERT INTO persona VALUES(" 
                + persona.getCc().toString() +"," +
                persona.getNombre() +"," +
                persona.getApellido()+"," +
                persona.getGenero().toString() +")" ,Persona.class);
        
        query.executeUpdate();
    }
    
    //void edit(Persona persona);
    
    @Override
    public void edit(Persona persona)
    {
        TypedQuery<Persona> query = em.createQuery("UPDATE persona "
                + "SET nombre = ?1 , apellido = ?2 , genero = ?3 "
                + "WHERE cc = ?4",  Persona.class);
        query.setParameter(1, persona.getNombre());
        query.setParameter(2, persona.getApellido());
        query.setParameter(3, persona.getGenero());
        query.setParameter(4, persona.getCc());
               
        
        query.executeUpdate();
    }

    //void remove(Persona persona);

    @Override
    public void remove(Persona persona)
    {
        TypedQuery<Persona> query = em.createQuery("DELETE FROM persona WHERE persona.cc = ?1" ,Persona.class);
        query.setParameter(1, persona.getCc());
        
        query.executeUpdate();
    }

    
    public Persona find(int id)
    {
       
        TypedQuery<Persona> query;
        query = em.createQuery("select p from persona p WHERE p.Cc = ?1 ",Persona.class);
        query.setParameter(1, id);
        
        return query.getSingleResult();
        
    }
    

    
}
