package com.ceiba.alquiler.persona.servicio.testdatabuilder;

import com.ceiba.alquiler.comando.ComandoPersona;

public class ComandoPersonaTestDataBuilder {

    private Integer idPersona;
    private Integer cedula;
    private String nombre;
    private String apellido;
    private Integer telefono;
    private String direccion;

    public ComandoPersonaTestDataBuilder() {
        cedula = 103666253;
        nombre = "Prueba";
        apellido = "Integracion";
        telefono = 2222222;
        direccion = "calle 10";
    }

    public ComandoPersonaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoPersona build() {
        return new ComandoPersona(idPersona,cedula, nombre,apellido,telefono,direccion);
    }
}
