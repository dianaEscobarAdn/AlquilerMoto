package com.ceiba.alquiler.puerto.dao;

import com.ceiba.alquiler.modelo.entidad.Solicitud;

import java.util.List;

public interface DaoSolicitud {

    /**
     * Permite listar solicitud
     * @return las solicitud
     */
    List<Solicitud> consultarSolicitudes();

    Solicitud consultarSolicitud(Integer idSolicitud);
}
