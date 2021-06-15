package com.ceiba.alquiler.puerto.repositorio;

import com.ceiba.alquiler.modelo.entidad.Persona;

public interface RepositorioPersona {

    Integer crear(Persona persona);

    Persona buscarPersonaPorId(Integer idPersona);

    //void actualizar(Persona persona);
}
