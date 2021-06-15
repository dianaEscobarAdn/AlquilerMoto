package com.ceiba.alquiler.comando.manejador;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoPersona;
import com.ceiba.alquiler.comando.fabrica.FabricaPersona;
import com.ceiba.alquiler.manejador.ManejadorComandoRespuesta;
import com.ceiba.alquiler.modelo.entidad.Persona;
import com.ceiba.alquiler.ServicioCrearPersona;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPersona implements ManejadorComandoRespuesta<ComandoPersona, ComandoRespuesta<Integer>> {

    private final FabricaPersona fabricaPersona;
    private ServicioCrearPersona servicioCrearPersona;

    public ManejadorCrearPersona(FabricaPersona fabricaPersona, ServicioCrearPersona servicioCrearPersona) {
        this.fabricaPersona = fabricaPersona;
        this.servicioCrearPersona = servicioCrearPersona;
    }

    public ComandoRespuesta<Integer> ejecutar(ComandoPersona comandoPersona) {
        Persona persona = this.fabricaPersona.crear(comandoPersona);
        return new ComandoRespuesta<>(this.servicioCrearPersona.ejecutar(persona));
    }
}
