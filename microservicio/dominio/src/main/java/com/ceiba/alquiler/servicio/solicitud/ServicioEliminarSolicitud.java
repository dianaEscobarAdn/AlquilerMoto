package com.ceiba.alquiler.servicio.solicitud;

import com.ceiba.alquiler.puerto.repositorio.RepositorioSolicitud;

public class ServicioEliminarSolicitud {

    private final RepositorioSolicitud repositorioSolicitud;

    public ServicioEliminarSolicitud(RepositorioSolicitud repositorioSolicitud) {
        this.repositorioSolicitud = repositorioSolicitud;
    }

    public void ejecutar(Integer idSolicitud) {
        this.repositorioSolicitud.eliminar(idSolicitud);
    }

}