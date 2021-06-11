package com.ceiba.alquiler.persistencia.respositorios;

import com.ceiba.alquiler.modelo.entidad.Solicitud;
import com.ceiba.alquiler.persistencia.dao.DaoSolicitudH2;
import com.ceiba.alquiler.persistencia.entidades.EntidadSolicitud;
import com.ceiba.alquiler.puerto.repositorio.RepositorioSolicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioSolicitudImpl implements RepositorioSolicitud {

    @Autowired
    private DaoSolicitudH2 daoSolicitudH2;

    private List<Solicitud> listSolicitud;

    @Override
    public Integer crear(Solicitud solicitud) {
        EntidadSolicitud solicitudCreada = this.daoSolicitudH2.save(new EntidadSolicitud(
                solicitud.getIdProducto(),
                solicitud.getIdPersona(),
                solicitud.getFechaSolicitud(),
                solicitud.getDiasAlquiler(),
                solicitud.getFechaDevolucion(),
                solicitud.getValorSolicitud(),
                solicitud.getValorDeposito()
        ));
        return solicitudCreada.getIdProducto();
    }
}
