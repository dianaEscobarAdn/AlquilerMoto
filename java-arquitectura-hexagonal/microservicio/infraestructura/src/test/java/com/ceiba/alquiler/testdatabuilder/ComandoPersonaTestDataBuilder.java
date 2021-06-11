package com.ceiba.alquiler.testdatabuilder;

import com.ceiba.alquiler.comando.ComandoPersona;

import java.util.UUID;

public class ComandoPersonaTestDataBuilder {

    private Integer idPersona;
    private int cedula;
    private String nombre;
    private String apellido;
    private int telefono;
    private String direccion;

    public ComandoPersonaTestDataBuilder() {
        cedula = 12345;
        nombre = "Diana";
        apellido = "prueba";
        telefono = 2222222;
        direccion ="calle 10";
    }

    public ComandoPersonaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoPersona build() {
        return new ComandoPersona(idPersona,cedula, nombre,apellido,telefono,direccion);
    }
}
