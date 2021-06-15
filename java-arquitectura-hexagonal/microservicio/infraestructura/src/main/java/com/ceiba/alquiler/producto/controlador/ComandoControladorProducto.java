package com.ceiba.alquiler.producto.controlador;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoProducto;
import com.ceiba.alquiler.comando.manejador.ManejadorCrearProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
@Api(tags = { "Controlador comando producto"})
public class ComandoControladorProducto {

    private final ManejadorCrearProducto manejadorCrearProducto;

    @Autowired
    public ComandoControladorProducto(ManejadorCrearProducto manejadorCrearProducto) {
        this.manejadorCrearProducto = manejadorCrearProducto;
    }

    @PostMapping
    @ApiOperation("Crear Producto")
    public ComandoRespuesta<Integer> crear(@RequestBody ComandoProducto comandoProducto) {
        return manejadorCrearProducto.ejecutar(comandoProducto);
    }
}
