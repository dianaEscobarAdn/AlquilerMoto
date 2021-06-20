package com.ceiba.alquiler.comando.manejador;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoPersona;
import com.ceiba.alquiler.comando.fabrica.FabricaPersona;
import com.ceiba.alquiler.manejador.ManejadorComandoRespuesta;
import com.ceiba.alquiler.modelo.dto.DtoRespuestaPersona;
import com.ceiba.alquiler.modelo.entidad.Persona;
import com.ceiba.alquiler.servicio.persona.ServicioRegistrarPersona;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPersona implements ManejadorComandoRespuesta<ComandoPersona, ComandoRespuesta<DtoRespuestaPersona>> {

    private final FabricaPersona fabricaPersona;
    private ServicioRegistrarPersona servicioRegistrarPersona;

    public ManejadorCrearPersona(FabricaPersona fabricaPersona, ServicioRegistrarPersona servicioRegistrarPersona) {
        this.fabricaPersona = fabricaPersona;
        this.servicioRegistrarPersona = servicioRegistrarPersona;
    }

    public ComandoRespuesta<DtoRespuestaPersona> ejecutar(ComandoPersona comandoPersona) {
        Persona persona = this.fabricaPersona.crear(comandoPersona);
        return new ComandoRespuesta<>(this.servicioRegistrarPersona.ejecutar(persona));
    }
}