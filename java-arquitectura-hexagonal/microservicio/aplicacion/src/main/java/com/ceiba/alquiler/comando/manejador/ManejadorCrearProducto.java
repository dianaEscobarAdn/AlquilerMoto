package com.ceiba.alquiler.comando.manejador;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoProducto;
import com.ceiba.alquiler.comando.fabrica.FabricaProducto;
import com.ceiba.alquiler.manejador.ManejadorComandoRespuesta;
import com.ceiba.alquiler.modelo.dto.DtoRespuestaProducto;
import com.ceiba.alquiler.modelo.entidad.Producto;
import com.ceiba.alquiler.ServicioCrearProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearProducto implements ManejadorComandoRespuesta<ComandoProducto, ComandoRespuesta<DtoRespuestaProducto>> {

    private final FabricaProducto fabricaProducto;
    private ServicioCrearProducto servicioCrearProducto;

    public ManejadorCrearProducto(FabricaProducto fabricaProducto, ServicioCrearProducto servicioCrearProducto) {
        this.fabricaProducto = fabricaProducto;
        this.servicioCrearProducto = servicioCrearProducto;
    }

    public ComandoRespuesta<DtoRespuestaProducto> ejecutar(ComandoProducto comandoProducto) {
        Producto producto = this.fabricaProducto.crear(comandoProducto);
        return new ComandoRespuesta<>(this.servicioCrearProducto.ejecutar(producto));
    }
}