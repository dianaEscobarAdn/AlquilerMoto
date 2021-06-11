package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.dto.DtoProducto;
import com.ceiba.alquiler.modelo.entidad.Producto;
import com.ceiba.alquiler.puerto.repositorio.RepositorioProducto;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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
        String respuesta = new ServicioCrearProducto(repositorioProducto).ejecutar(this.producto);
        //Validacion del Test
        assertEquals("Se ha creado el producto correctamente, con código: 123, Descripción: Moto, Unidades: 10", respuesta);
    }

    /*@Test
    public void crearDtoProducto() {
        DtoProducto pro = new DtoProducto (
                1,
                "123",
                "Moto",
                10,
                5
        );
        assertEquals(1, pro.getIdProducto());
    }

   @Test
    public void crearProductoConCantidadesSolicitadasMayoresALasDisponiblesTest() {
        //Configuracion para el Test
        Producto productoFallido = new Producto(null,"123", "Moto", 10, 15);
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.crear(productoFallido)).thenReturn(1);

        Mockito.when(repositorioProducto.buscarProductoPorId(1)).thenReturn(new Producto(
                1,
                "123",
                "Moto",
                10,
                15
        ));

        //Ejecuccion del Test
        String respuesta = new ServicioCrearProducto(repositorioProducto).ejecutar(productoFallido);
        //Validacion del Test
        assertEquals("Error: Las unidades comprometidas no puede ser mayor a las unidades disponibles", respuesta);
    }*/
}