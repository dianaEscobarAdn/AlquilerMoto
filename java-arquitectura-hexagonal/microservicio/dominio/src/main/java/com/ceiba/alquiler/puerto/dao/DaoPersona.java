package com.ceiba.alquiler.puerto.dao;

import com.ceiba.alquiler.modelo.dto.DtoPersona;
import com.ceiba.alquiler.modelo.entidad.Persona;

import java.util.List;

public interface DaoPersona {

    /**
     * Permite listar persona
     * @return las personas
     */
    List<Persona> consultarPersonas();

    Persona consultarPersona(Integer idPersona);
}
