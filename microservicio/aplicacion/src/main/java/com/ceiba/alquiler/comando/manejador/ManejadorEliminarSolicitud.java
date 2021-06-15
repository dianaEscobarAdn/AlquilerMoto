package com.ceiba.alquiler.comando.manejador;

import com.ceiba.alquiler.manejador.ManejadorComando;
import com.ceiba.alquiler.servicio.solicitud.ServicioEliminarSolicitud;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarSolicitud implements ManejadorComando<Integer> {

    private final ServicioEliminarSolicitud servicioEliminarSolicitud;

    public ManejadorEliminarSolicitud(ServicioEliminarSolicitud servicioEliminarSolicitud) {
        this.servicioEliminarSolicitud = servicioEliminarSolicitud;
    }

    public void ejecutar(Integer idSolicitud) {
        this.servicioEliminarSolicitud.ejecutar(idSolicitud);
    }
}