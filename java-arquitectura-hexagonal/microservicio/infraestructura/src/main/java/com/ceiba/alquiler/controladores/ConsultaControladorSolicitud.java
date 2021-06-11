package com.ceiba.alquiler.controladores;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoSolicitud;
import com.ceiba.alquiler.consulta.ManejadorListarSolicitud;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/solicitud")
public class ConsultaControladorSolicitud {
    private ManejadorListarSolicitud manejadorListarSolicitud;

    public ConsultaControladorSolicitud(ManejadorListarSolicitud manejadorListarSolicitud) {
        this.manejadorListarSolicitud = manejadorListarSolicitud;
    }

    @GetMapping
    public ResponseEntity<ComandoRespuesta<List<ComandoSolicitud>>> listar() {
        return new ResponseEntity<>(this.manejadorListarSolicitud.ejecutar(), HttpStatus.OK);
    }
}