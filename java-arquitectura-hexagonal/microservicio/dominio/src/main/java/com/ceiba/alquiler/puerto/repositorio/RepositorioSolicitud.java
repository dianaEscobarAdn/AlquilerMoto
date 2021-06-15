package com.ceiba.alquiler.puerto.repositorio;

import com.ceiba.alquiler.modelo.entidad.Solicitud;

public interface RepositorioSolicitud {
    /**
     * Permite crear una solicitud
     * @param solicitud
     * @return el id generado
     */
    Integer crear(Solicitud solicitud);

    Solicitud buscarSolicitudPorId(Integer idSolicitud);

  //  void actualizar(Solicitud solicitud);
}
