package com.ceiba.alquiler.controladores;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoProducto;
import com.ceiba.alquiler.comando.manejador.ManejadorCrearProducto;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
@Api(tags = { "Controlador comando producto"})
public class ComandoControladorProducto {
    private ManejadorCrearProducto crearProducto;

    public ComandoControladorProducto(ManejadorCrearProducto crearProducto) {
        this.crearProducto = crearProducto;
    }

    @PostMapping
    public ResponseEntity<ComandoRespuesta<String>> crearProducto(@RequestBody ComandoProducto producto) {
        return new ResponseEntity<>(this.crearProducto.ejecutar(producto),HttpStatus.OK);
    }
}
