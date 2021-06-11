package com.ceiba.alquiler.controladores;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoPersona;
import com.ceiba.alquiler.consulta.ManejadorListarPersonas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class ConsultaControladorPersona {
    private ManejadorListarPersonas manejadorListarPersona;

    public ConsultaControladorPersona(ManejadorListarPersonas manejadorListarPersona) {
        this.manejadorListarPersona = manejadorListarPersona;
    }

    @GetMapping
    public ResponseEntity<ComandoRespuesta<List<ComandoPersona>>> listar() {
        return new ResponseEntity<>(this.manejadorListarPersona.ejecutar(), HttpStatus.OK);
    }
}