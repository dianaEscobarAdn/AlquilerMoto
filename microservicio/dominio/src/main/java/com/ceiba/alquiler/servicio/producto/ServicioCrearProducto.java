package com.ceiba.alquiler.servicio.producto;

import com.ceiba.alquiler.dominio.ValidadorArgumento;
import com.ceiba.alquiler.modelo.dto.DtoRespuestaProducto;
import com.ceiba.alquiler.modelo.entidad.Producto;
import com.ceiba.alquiler.puerto.repositorio.RepositorioProducto;


public class ServicioCrearProducto {

    private final RepositorioProducto repositorioProducto;

    public static final String ERROR_NO_ENCONTRO_EL_PRODUCTO_CREADO = "Error: no encontro el producto creado";

    public ServicioCrearProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public DtoRespuestaProducto ejecutar(Producto producto) {
       Integer idProducto = this.repositorioProducto.crear(producto);
       Producto productoCreado = this.repositorioProducto.buscarProductoPorId(idProducto);
       ValidadorArgumento.validarObligatorio(productoCreado, ERROR_NO_ENCONTRO_EL_PRODUCTO_CREADO);
       return convertirADtoRespuesta(productoCreado);
    }

    public DtoRespuestaProducto convertirADtoRespuesta (Producto productoCreado){
        return new DtoRespuestaProducto(
                productoCreado.getIdProducto(),
                productoCreado.getCodigoProducto(),
                productoCreado.getDescripcionProducto(),
                productoCreado.getUnidadesDisponibles(),
                productoCreado.getUnidadesComprometidas()
        );
    }
}