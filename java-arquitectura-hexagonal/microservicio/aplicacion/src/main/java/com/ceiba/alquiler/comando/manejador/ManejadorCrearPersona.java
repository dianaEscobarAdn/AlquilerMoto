package com.ceiba.alquiler.comando.manejador;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoPersona;
import com.ceiba.alquiler.comando.fabrica.FabricaPersona;
import com.ceiba.alquiler.manejador.ManejadorComandoRespuesta;
import com.ceiba.alquiler.modelo.entidad.Persona;
import com.ceiba.alquiler.puerto.repositorio.RepositorioPersona;
import com.ceiba.alquiler.servicio.ServicioCrearPersona;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPersona implements ManejadorComandoRespuesta<ComandoPersona, ComandoRespuesta<String>> {

    private final FabricaPersona fabricaPersona;
    private RepositorioPersona repositorioPersona;

    public ManejadorCrearPersona(FabricaPersona fabricaPersona, RepositorioPersona repositorioPersona) {
        this.fabricaPersona = fabricaPersona;
        this.repositorioPersona = repositorioPersona;
    }

    public ComandoRespuesta<String> ejecutar(ComandoPersona comandoPersona) {
        Persona persona = this.fabricaPersona.crear(comandoPersona);
        return new ComandoRespuesta<>(new ServicioCrearPersona(this.repositorioPersona).ejecutar(persona));
    }
}
