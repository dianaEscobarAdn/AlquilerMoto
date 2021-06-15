package com.ceiba.alquiler.persona.controlador;

import com.ceiba.alquiler.consulta.ManejadorListarPersonas;
import com.ceiba.alquiler.modelo.dto.DtoPersona;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persona")
@Api(tags={"Controlador consulta persona"})
public class ConsultaControladorPersona {

    private final ManejadorListarPersonas manejadorListarPersonas;

    public ConsultaControladorPersona(ManejadorListarPersonas manejadorListarPersonas) {
        this.manejadorListarPersonas = manejadorListarPersonas;
    }

    @GetMapping
    @ApiOperation("Listar Personas")
    public List<DtoPersona> listar() {
        return this.manejadorListarPersonas.ejecutar();
    }

}