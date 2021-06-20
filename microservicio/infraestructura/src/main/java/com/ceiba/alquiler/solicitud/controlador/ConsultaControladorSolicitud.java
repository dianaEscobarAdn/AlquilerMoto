package com.ceiba.alquiler.solicitud.controlador;

import com.ceiba.alquiler.consulta.ManejadorListarSolicitud;
import com.ceiba.alquiler.modelo.dto.DtoSolicitud;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/solicitud")
@Api(tags={"Controlador consulta solicitud"})
@CrossOrigin(origins = {"http://localhost:4200"} ,maxAge = 600)
public class ConsultaControladorSolicitud {

    private final ManejadorListarSolicitud manejadorListarSolicitud;

    public ConsultaControladorSolicitud(ManejadorListarSolicitud manejadorListarSolicitud) {
        this.manejadorListarSolicitud = manejadorListarSolicitud;
    }

    @GetMapping
    @ApiOperation("Listar solicitudes")
    public List<DtoSolicitud> listar() {
        return this.manejadorListarSolicitud.ejecutar();
    }
}