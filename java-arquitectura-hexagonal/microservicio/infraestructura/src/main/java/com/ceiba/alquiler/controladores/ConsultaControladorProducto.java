package com.ceiba.alquiler.controladores;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoProducto;
import com.ceiba.alquiler.consulta.ManejadorListarProducto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ConsultaControladorProducto {
    private ManejadorListarProducto manejadorListarProducto;

    public ConsultaControladorProducto(ManejadorListarProducto manejadorListarProducto) {
        this.manejadorListarProducto = manejadorListarProducto;
    }

    @GetMapping
    public ResponseEntity<ComandoRespuesta<List<ComandoProducto>>> listar() {
        return new ResponseEntity<>(this.manejadorListarProducto.ejecutar(), HttpStatus.OK);
    }
}