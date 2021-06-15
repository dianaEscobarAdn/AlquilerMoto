package com.ceiba.alquiler.comando.manejador;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.servicio.solicitud.ServicioCrearSolicitud;
import com.ceiba.alquiler.comando.ComandoSolicitud;
import com.ceiba.alquiler.comando.fabrica.FabricaSolicitud;
import com.ceiba.alquiler.manejador.ManejadorComandoRespuesta;
import com.ceiba.alquiler.modelo.dto.DtoRespuestaSolicitud;
import com.ceiba.alquiler.modelo.entidad.Solicitud;
import com.ceiba.alquiler.puerto.repositorio.RepositorioProducto;
import com.ceiba.alquiler.puerto.repositorio.RepositorioSolicitud;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearSolicitud implements ManejadorComandoRespuesta<ComandoSolicitud, ComandoRespuesta<DtoRespuestaSolicitud>> {

    private final FabricaSolicitud fabricaSolicitud;
    private RepositorioSolicitud repositorioSolicitud;
    private RepositorioProducto repositorioProducto;

    public ManejadorCrearSolicitud(FabricaSolicitud fabricaSolicitud, RepositorioSolicitud repositorioSolicitud, RepositorioProducto repositorioProducto) {
        this.fabricaSolicitud = fabricaSolicitud;
        this.repositorioSolicitud = repositorioSolicitud;
        this.repositorioProducto = repositorioProducto;
    }

    public ComandoRespuesta<DtoRespuestaSolicitud> ejecutar(ComandoSolicitud comandoSolicitud) {
        Solicitud solicitud = this.fabricaSolicitud.crear(comandoSolicitud);
        return new ComandoRespuesta<>(new ServicioCrearSolicitud(this.repositorioSolicitud, this.repositorioProducto).ejecutar(solicitud));
    }
}
