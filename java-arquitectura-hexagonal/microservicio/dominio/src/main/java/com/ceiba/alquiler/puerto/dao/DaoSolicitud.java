package com.ceiba.alquiler.puerto.dao;

import com.ceiba.alquiler.modelo.dto.DtoSolicitud;

import java.util.List;

public interface DaoSolicitud {


    List<DtoSolicitud> consultarSolicitudes();

    DtoSolicitud consultarSolicitud(Integer idSolicitud);

}