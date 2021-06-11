package com.ceiba.alquiler.persistencia.respositorios;

import com.ceiba.alquiler.modelo.entidad.Solicitud;
import com.ceiba.alquiler.persistencia.dao.DaoSolicitudH2;
import com.ceiba.alquiler.persistencia.entidades.EntidadSolicitud;
import com.ceiba.alquiler.puerto.dao.DaoSolicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoSolicitudmpl implements DaoSolicitud {
    @Autowired
    private DaoSolicitudH2 daoSolicitudH2;

    private List<Solicitud> listSolicitud;

    @Override
    public List<Solicitud> consultarSolicitudes() {
        listSolicitud = new ArrayList<>();
        this.daoSolicitudH2.findAll().forEach(solicitud -> {
            this.listSolicitud.add(
                    new Solicitud(
                        solicitud.getIdSolicitud(),
                        solicitud.getIdProducto(),
                        solicitud.getIdPersona(),
                        solicitud.getFechaSolicitud(),
                        solicitud.getDiasAlquiler(),
                        solicitud.getFechaDevolucion(),
                        solicitud.getValorSolicitud(),
                        solicitud.getValorDeposito()
                    )
            );
        });
        return this.listSolicitud;
    }

    @Override
    public Solicitud consultarSolicitud(Integer id) {
        EntidadSolicitud SolicitudBuscada = this.daoSolicitudH2.findById(id).orElse(null);
        if (SolicitudBuscada != null) {
            return new Solicitud(
                    SolicitudBuscada.getIdSolicitud(),
                    SolicitudBuscada.getIdProducto(),
                    SolicitudBuscada.getIdPersona(),
                    SolicitudBuscada.getFechaSolicitud(),
                    SolicitudBuscada.getDiasAlquiler(),
                    SolicitudBuscada.getFechaDevolucion(),
                    SolicitudBuscada.getValorSolicitud(),
                    SolicitudBuscada.getValorDeposito()
            );
        }
        return null;
    }

}
