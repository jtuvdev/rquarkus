package org.personas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(
    @NamedQuery(name = "Persona.encontrarTodasPersonas", query = "SELECT p FROM Persona p ORDER BY p.idPersona")
)
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int idPersona;

    @Column(name = "nombre")
    private String nombre;
    private String apellido;
    private String email;

}