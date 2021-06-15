package com.ceiba.alquiler.servicio.producto;

import com.ceiba.alquiler.modelo.dto.DtoRespuestaProducto;
import com.ceiba.alquiler.modelo.entidad.Producto;
import com.ceiba.alquiler.puerto.repositorio.RepositorioProducto;


public class ServicioCrearProducto {

    private final RepositorioProducto repositorioProducto;

    public ServicioCrearProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public DtoRespuestaProducto ejecutar(Producto producto) {
       Integer idProducto = this.repositorioProducto.crear(producto);
       Producto productoCreado = this.repositorioProducto.buscarProductoPorId(idProducto);
       DtoRespuestaProducto dtoRespuestaPersona = ConvertirADtoRespuesta(productoCreado);
       return dtoRespuestaPersona;
    }

    public DtoRespuestaProducto ConvertirADtoRespuesta (Producto productoCreado){
        return productoCreado != null ? new DtoRespuestaProducto(
                productoCreado.getIdProducto(),
                productoCreado.getCodigoProducto(),
                productoCreado.getDescripcionProducto(),
                productoCreado.getUnidadesDisponibles(),
                productoCreado.getUnidadesComprometidas()
        ) : null;
    }
}