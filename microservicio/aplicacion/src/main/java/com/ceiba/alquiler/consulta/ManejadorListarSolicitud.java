package com.ceiba.alquiler.consulta;

import com.ceiba.alquiler.modelo.dto.DtoSolicitud;
import com.ceiba.alquiler.puerto.dao.DaoSolicitud;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarSolicitud {

    private final DaoSolicitud daoSolicitud;

    public ManejadorListarSolicitud(DaoSolicitud daoSolicitud) {
        this.daoSolicitud = daoSolicitud;
    }

    public List<DtoSolicitud> ejecutar(){ return this.daoSolicitud.consultarSolicitudes(); }
}