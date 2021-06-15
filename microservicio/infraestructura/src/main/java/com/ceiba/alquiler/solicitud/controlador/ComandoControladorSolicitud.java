package com.ceiba.alquiler.solicitud.controlador;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoSolicitud;
import com.ceiba.alquiler.comando.manejador.ManejadorCrearSolicitud;
import com.ceiba.alquiler.modelo.dto.DtoRespuestaSolicitud;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solicitud")
@Api(tags = { "Controlador comando solicitud"})
public class ComandoControladorSolicitud {

    private final ManejadorCrearSolicitud manejadorCrearSolicitud;

    //@Autowired
    public ComandoControladorSolicitud(ManejadorCrearSolicitud manejadorCrearSolicitud) {
        this.manejadorCrearSolicitud = manejadorCrearSolicitud;
    }

    @PostMapping
    @ApiOperation("Crear Solicitud")
    public ComandoRespuesta<DtoRespuestaSolicitud> crear(@RequestBody ComandoSolicitud comandoSolicitud) {
        return manejadorCrearSolicitud.ejecutar(comandoSolicitud);
    }
}