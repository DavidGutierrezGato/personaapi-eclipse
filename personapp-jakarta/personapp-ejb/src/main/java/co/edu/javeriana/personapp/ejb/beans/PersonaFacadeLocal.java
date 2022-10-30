/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.javeriana.personapp.ejb.beans;

import co.edu.javeriana.personapp.ejb.entities.Persona;
import java.util.List;
import javax.ejb.Local;

import javax.inject.Named;


/**
 *
 * @author User
 */
@Local
public interface PersonaFacadeLocal {

    void create(Persona persona);

    void edit(Persona persona);

    void remove(Persona persona);

    Persona find(Object id);

    List<Persona> findAll();

    List<Persona> findRange(int[] range);

    int count();
    
    public Persona find(int id);
}
