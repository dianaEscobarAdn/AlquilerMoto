package com.ceiba.alquiler.producto.controlador;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoProducto;
import com.ceiba.alquiler.comando.manejador.ManejadorCrearProducto;
import com.ceiba.alquiler.comando.manejador.ManejadorEliminarProducto;
import com.ceiba.alquiler.modelo.dto.DtoRespuestaProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
@Api(tags = { "Controlador comando producto"})
@CrossOrigin(origins = {"http://localhost:4200"} ,maxAge = 600)
public class ComandoControladorProducto {

    private final ManejadorCrearProducto manejadorCrearProducto;
    private final ManejadorEliminarProducto manejadorEliminarProducto;

    @Autowired
    public ComandoControladorProducto(ManejadorCrearProducto manejadorCrearProducto,ManejadorEliminarProducto manejadorEliminarProducto) {
        this.manejadorCrearProducto = manejadorCrearProducto;
        this.manejadorEliminarProducto = manejadorEliminarProducto;
    }

    @PostMapping
    @CrossOrigin(origins = {"http://localhost:4200"} ,maxAge = 600)
    @ApiOperation("Crear Producto")
    public ComandoRespuesta<DtoRespuestaProducto> crear(@RequestBody ComandoProducto comandoProducto) {
        return manejadorCrearProducto.ejecutar(comandoProducto);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Producto")
    public void eliminar(@PathVariable Integer id) {manejadorEliminarProducto.ejecutar(id);}
}