package com.ceiba.alquiler.servicio.persona;

import com.ceiba.alquiler.puerto.repositorio.RepositorioPersona;

public class ServicioEliminarPersona {

    private final RepositorioPersona repositorioPersona;

    public ServicioEliminarPersona(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public void ejecutar(Integer idPersona) {
        this.repositorioPersona.eliminar(idPersona);
    }

}