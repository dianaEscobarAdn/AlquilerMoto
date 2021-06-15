package com.ceiba.alquiler.comando.manejador;

import com.ceiba.alquiler.manejador.ManejadorComando;
import com.ceiba.alquiler.servicio.producto.ServicioEliminarProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarProducto implements ManejadorComando<Integer> {

    private final ServicioEliminarProducto servicioEliminarProducto;

    public ManejadorEliminarProducto(ServicioEliminarProducto servicioEliminarProducto) {
        this.servicioEliminarProducto = servicioEliminarProducto;
    }

    public void ejecutar(Integer idProducto) {
        this.servicioEliminarProducto.ejecutar(idProducto);
    }
}