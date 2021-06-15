package com.ceiba.alquiler.puerto.dao;

import com.ceiba.alquiler.modelo.dto.DtoSolicitud;
import com.ceiba.alquiler.modelo.entidad.Solicitud;

import java.util.List;

public interface DaoSolicitud {

    /**
     * Permite listar solicitud
     * @return las solicitud
     */
    List<DtoSolicitud> consultarSolicitudes();

    DtoSolicitud consultarSolicitud(Integer idSolicitud);
}
