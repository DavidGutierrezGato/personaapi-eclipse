/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.personapp.ejb.beans.impl;

import co.edu.javeriana.personapp.ejb.beans.AbstractFacade;
import co.edu.javeriana.personapp.ejb.beans.ProfesionFacadeLocal;
import co.edu.javeriana.personapp.ejb.entities.Profesion;
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
public class ProfesionFacade extends AbstractFacade<Profesion> implements ProfesionFacadeLocal {

    @PersistenceContext(unitName = "persona_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfesionFacade() {
        super(Profesion.class);
    }

    @Override
    public Profesion find(Object id) {
        TypedQuery<Profesion> query = em.createQuery("select p FROM profesion p WHERE p.nom = ?1" ,Profesion.class);
        query.setParameter(1, id);
        
        query.executeUpdate();
        
        return query.getSingleResult();
        
    }

    @Override
    public List<Profesion> findAll() {
        TypedQuery<Profesion> query = em.createQuery("select p FROM profesion p " ,Profesion.class);
        
        
        query.executeUpdate();
        
        return query.getResultList();
        
    }

    @Override
    public void create(Profesion entity) {
        TypedQuery<Profesion> query = em.createQuery("INSERT INTO profesion VALUES(" 
                + entity.getNom() +"," +
                entity.getDes()+"," +
                entity.getEstudiosList()+")" ,Profesion.class);
        
        query.executeUpdate();
    }

    @Override
    public void edit(Profesion entity) {
        TypedQuery<Profesion> query = em.createQuery("UPDATE profesion "
                + "SET nom = ?1 , des = ?2 , estudiosList = ?3 "
                + "WHERE nom = ?1",  Profesion.class);
        query.setParameter(1, entity.getNom());
        query.setParameter(2, entity.getDes());
        query.setParameter(3, entity.getEstudiosList());

        query.executeUpdate();
        
    }

    @Override
    public void remove(Profesion entity) {
        TypedQuery<Profesion> query = em.createQuery("DELETE FROM profesion WHERE profesion.nom = ?1" ,Profesion.class);
        query.setParameter(1, entity.getNom());
        
        query.executeUpdate();
    }
    
    
    
    
}
