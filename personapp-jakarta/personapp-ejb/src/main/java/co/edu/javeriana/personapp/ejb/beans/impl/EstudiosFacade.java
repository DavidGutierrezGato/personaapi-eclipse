/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.personapp.ejb.beans.impl;

import co.edu.javeriana.personapp.ejb.beans.AbstractFacade;
import co.edu.javeriana.personapp.ejb.beans.EstudiosFacadeLocal;
import co.edu.javeriana.personapp.ejb.entities.Estudios;
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
public class EstudiosFacade extends AbstractFacade<Estudios> implements EstudiosFacadeLocal {

    @PersistenceContext(unitName = "persona_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudiosFacade() {
        super(Estudios.class);
    }

    
    public Estudios find(Object id,Object id2 ) {
        
        TypedQuery<Estudios> query;
        query = em.createQuery("select p from Estudios p WHERE p.persona = ?1 and p.profesion = ?2",Estudios.class);
        query.setParameter(1, id);
        query.setParameter(2, id2);
        
        return query.getSingleResult();
    }

    @Override
    public List<Estudios> findAll() {
        TypedQuery<Estudios> query;
        query = em.createQuery("select p from Estudios p ",Estudios.class);

        return query.getResultList();
    }

    @Override
    public void create(Estudios entity) {
         TypedQuery<Estudios> query = em.createQuery("UPDATE estudios  "
                + "SET persona = ?1 , profesion = ?2 , fecha = ?3 , univer = =4" 
                + "WHERE persona = ?1 and profesion = ?2" ,  Estudios.class);
                 
                query.setParameter(1, entity.getPersona().getCc());
                query.setParameter(2, entity.getProfesion().getNom());
                query.setParameter(3, entity.getFecha());
                query.setParameter(4, entity.getUniver());
                
        query.executeUpdate();
    }

    @Override
    public void edit(Estudios entity) {
        TypedQuery<Estudios> query = em.createQuery("INSERT INTO estudios VALUES(" 
                + entity.getPersona().getCc() +"," +
                entity.getProfesion().getNom() +"," +
                entity.getFecha()+"," +
                entity.getUniver()+")" ,Estudios.class);
        
        query.executeUpdate();
    }

    @Override
    public void remove(Estudios entity) {
        TypedQuery<Estudios> query = em.createQuery("DELETE FROM estudios WHERE estudios.persona = ?1 and estudios.profesion = ?2" ,Estudios.class);
        query.setParameter(1, entity.getPersona().getCc());
        query.setParameter(2, entity.getProfesion().getNom());
        
        query.executeUpdate();
    }
    
    
}
