package com.ceiba.alquiler.solicitud.controlador;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoSolicitud;
import com.ceiba.alquiler.comando.manejador.ManejadorCrearSolicitud;
import com.ceiba.alquiler.comando.manejador.ManejadorEliminarSolicitud;
import com.ceiba.alquiler.modelo.dto.DtoRespuestaSolicitud;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitud")
@Api(tags = { "Controlador comando solicitud"})
public class ComandoControladorSolicitud {

    private final ManejadorCrearSolicitud manejadorCrearSolicitud;
    private final ManejadorEliminarSolicitud manejadorEliminarSolicitud;

    //@Autowired
    public ComandoControladorSolicitud(ManejadorCrearSolicitud manejadorCrearSolicitud,ManejadorEliminarSolicitud manejadorEliminarSolicitud) {
        this.manejadorCrearSolicitud = manejadorCrearSolicitud;
        this.manejadorEliminarSolicitud = manejadorEliminarSolicitud;
    }

    @PostMapping
    @ApiOperation("Crear Solicitud")
    public ComandoRespuesta<DtoRespuestaSolicitud> crear(@RequestBody ComandoSolicitud comandoSolicitud) {
        return manejadorCrearSolicitud.ejecutar(comandoSolicitud);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Solicitud")
    public void eliminar(@PathVariable Integer id) {manejadorEliminarSolicitud.ejecutar(id);}
}