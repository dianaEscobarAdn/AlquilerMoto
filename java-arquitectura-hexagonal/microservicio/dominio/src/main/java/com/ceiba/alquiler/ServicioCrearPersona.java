package com.ceiba.alquiler;

import com.ceiba.alquiler.modelo.entidad.Persona;
import com.ceiba.alquiler.puerto.repositorio.RepositorioPersona;

public class ServicioCrearPersona {

    private final RepositorioPersona repositorioPersona;

    public ServicioCrearPersona(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public Integer ejecutar(Persona persona) {
        return this.repositorioPersona.crear(persona);
    }
}
