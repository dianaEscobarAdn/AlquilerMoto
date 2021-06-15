package com.ceiba.alquiler.producto.controlador;

import com.ceiba.alquiler.consulta.ManejadorListarProducto;
import com.ceiba.alquiler.modelo.dto.DtoProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
@Api(tags={"Controlador consulta producto"})
public class ConsultaControladorProducto {

    private final ManejadorListarProducto manejadorListarProducto;

    public ConsultaControladorProducto(ManejadorListarProducto manejadorListarProducto) {
        this.manejadorListarProducto = manejadorListarProducto;
    }

    @GetMapping
    @ApiOperation("Listar productos")
    public List<DtoProducto> listar() {
        return this.manejadorListarProducto.ejecutar();
    }

}