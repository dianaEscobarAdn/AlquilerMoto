package com.ceiba.alquiler.comando.fabrica;

import com.ceiba.alquiler.comando.ComandoSolicitud;
import com.ceiba.alquiler.modelo.entidad.Solicitud;
import org.springframework.stereotype.Component;

@Component
public class FabricaSolicitud {

    public Solicitud crear(ComandoSolicitud comandoSolicitud) {
        return new Solicitud(
                comandoSolicitud.getIdSolicitud(),
                comandoSolicitud.getIdProducto(),
                comandoSolicitud.getIdPersona(),
                comandoSolicitud.getFechaSolicitud(),
                comandoSolicitud.getDiasAlquiler()
        );
    }
}