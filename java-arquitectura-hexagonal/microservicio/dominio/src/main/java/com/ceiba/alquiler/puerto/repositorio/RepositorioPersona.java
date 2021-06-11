package com.ceiba.alquiler.puerto.repositorio;

import com.ceiba.alquiler.modelo.entidad.Persona;

public interface RepositorioPersona {
    /**
     * Permite crear una persona
     * @param persona
     * @return el id generado
     */
    Integer crear(Persona persona);
}
