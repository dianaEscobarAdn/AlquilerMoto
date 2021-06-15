package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.ServicioCrearProducto;
import com.ceiba.alquiler.modelo.dto.DtoPersona;
import com.ceiba.alquiler.modelo.dto.DtoProducto;
import com.ceiba.alquiler.modelo.dto.DtoRespuestaProducto;
import com.ceiba.alquiler.modelo.entidad.Producto;
import com.ceiba.alquiler.puerto.repositorio.RepositorioProducto;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearProductoTest {

    Producto producto;

    public ServicioCrearProductoTest() {this.producto = new Producto(null,"123", "Moto", 10, 5);}

    @Test
    public void crearProductoCorrectamenteTest() {
        //Configuracion para el Test
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.crear(this.producto)).thenReturn(1);

        Mockito.when(repositorioProducto.buscarProductoPorId(1)).thenReturn(new Producto(
                1,
                "123",
                "Moto",
                10,
                5
        ));

        //Ejecuccion del Test
        DtoRespuestaProducto respuesta = new ServicioCrearProducto(repositorioProducto).ejecutar(this.producto);
        //Validacion del Test
        assertEquals(1, respuesta.getIdProducto());
    }

    @Test
    public void crearDtoProducto() {
        DtoProducto producto = new DtoProducto (
                1,
                "Moto123",
                "Moto Dto",
                5,
                1
        );
        assertEquals(1, producto.getIdProducto());
        assertEquals("Moto123", producto.getCodigoProducto());
        assertEquals("Moto Dto", producto.getDescripcionProducto());
        assertEquals(5, producto.getUnidadesDisponibles());
        assertEquals(1, producto.getUnidadesComprometidas());
    }

    @Test
    public void crearDtoRespuestaProducto() {
        DtoRespuestaProducto producto = new DtoRespuestaProducto (
                1,
                "Moto123",
                "Moto Dto",
                5,
                1
        );
        assertEquals(1, producto.getIdProducto());
        assertEquals("Moto123", producto.getCodigoProducto());
        assertEquals("Moto Dto", producto.getDescripcionProducto());
        assertEquals(5, producto.getUnidadesDisponibles());
        assertEquals(1, producto.getUnidadesComprometidas());
    }
}