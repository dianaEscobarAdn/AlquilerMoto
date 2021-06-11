package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Persona;
import com.ceiba.alquiler.puerto.repositorio.RepositorioPersona;

public class ServicioCrearPersona {

    private final RepositorioPersona repositorioPersona;

    public ServicioCrearPersona(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public String ejecutar(Persona persona) {
        return "Se ha creado la persona con cedula: " + this.repositorioPersona.crear(persona);
    }
}
