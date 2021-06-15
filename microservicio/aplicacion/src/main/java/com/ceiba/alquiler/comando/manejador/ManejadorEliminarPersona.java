package com.ceiba.alquiler.comando.manejador;

import com.ceiba.alquiler.servicio.persona.ServicioEliminarPersona;
import com.ceiba.alquiler.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPersona implements ManejadorComando<Integer> {

    private final ServicioEliminarPersona servicioEliminarPersona;

    public ManejadorEliminarPersona(ServicioEliminarPersona servicioEliminarPersona) {
        this.servicioEliminarPersona = servicioEliminarPersona;
    }

    public void ejecutar(Integer idPersona) {
        this.servicioEliminarPersona.ejecutar(idPersona);
    }
}