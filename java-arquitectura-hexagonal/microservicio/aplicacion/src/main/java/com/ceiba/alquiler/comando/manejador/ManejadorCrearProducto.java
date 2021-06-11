package com.ceiba.alquiler.comando.manejador;

import com.ceiba.alquiler.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoProducto;
import com.ceiba.alquiler.comando.fabrica.FabricaProducto;
import com.ceiba.alquiler.manejador.ManejadorComandoRespuesta;
import com.ceiba.alquiler.modelo.entidad.Producto;
import com.ceiba.alquiler.puerto.repositorio.RepositorioProducto;
import com.ceiba.alquiler.servicio.ServicioCrearProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearProducto implements ManejadorComandoRespuesta<ComandoProducto, ComandoRespuesta<String>> {

    private final FabricaProducto fabricaProducto;
    private RepositorioProducto repositorioProducto;

    public ManejadorCrearProducto(FabricaProducto fabricaProducto, RepositorioProducto repositorioProducto) {
        this.fabricaProducto = fabricaProducto;
        this.repositorioProducto = repositorioProducto;
    }

    public ComandoRespuesta<String> ejecutar(ComandoProducto comandoProducto) {
        Producto producto = this.fabricaProducto.crear(comandoProducto);
        return new ComandoRespuesta<>(new ServicioCrearProducto(this.repositorioProducto).ejecutar(producto));
    }
}
