package com.ceiba.alquiler.puerto.repositorio;

import com.ceiba.alquiler.modelo.entidad.Solicitud;

public interface RepositorioSolicitud {

    Integer crear(Solicitud solicitud);

    Solicitud buscarSolicitudPorId(Integer idSolicitud);

}