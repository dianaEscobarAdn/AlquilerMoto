package com.ceiba.alquiler.puerto.dao;

import com.ceiba.alquiler.modelo.entidad.Persona;
import com.ceiba.alquiler.modelo.dto.DtoPersona;
import java.util.List;

public interface DaoPersona {

    /**
     * Permite consultar persona
     * @return las personas
     */
    DtoPersona consultarPersona(Integer idPersona);

    List<DtoPersona> consultarPersonas();
}
