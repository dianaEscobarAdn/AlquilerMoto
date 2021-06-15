package com.ceiba.alquiler.servicio.testdatabuilder;

import com.ceiba.alquiler.modelo.entidad.Persona;

public class PersonaTestDataBuilder {

    private Integer idPersona;
    private Integer cedula;
    private String nombre;
    private String apellido;
    private Integer telefono;
    private String direccion;

    public PersonaTestDataBuilder() {
        cedula = 123456;
        nombre = "Prueba";
        apellido = "Unitaria";
        telefono = 2222222;
        direccion = "Carrera 25c";
    }

    public Persona build() {
        return new Persona(idPersona,cedula, nombre,apellido,telefono,direccion);
    }
}
