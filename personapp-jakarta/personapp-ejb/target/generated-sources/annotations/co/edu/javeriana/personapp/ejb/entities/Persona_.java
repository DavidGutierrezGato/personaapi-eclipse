package co.edu.javeriana.personapp.ejb.entities;

import co.edu.javeriana.personapp.ejb.entities.Estudios;
import co.edu.javeriana.personapp.ejb.entities.Telefono;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-10-30T17:44:26")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, Integer> cc;
    public static volatile ListAttribute<Persona, Estudios> estudiosList;
    public static volatile SingularAttribute<Persona, String> apellido;
    public static volatile SingularAttribute<Persona, Character> genero;
    public static volatile ListAttribute<Persona, Telefono> telefonoList;
    public static volatile SingularAttribute<Persona, String> nombre;
    public static volatile SingularAttribute<Persona, Integer> edad;

}