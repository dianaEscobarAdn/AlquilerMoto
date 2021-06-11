package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Producto;
import com.ceiba.alquiler.modelo.entidad.Solicitud;
import com.ceiba.alquiler.puerto.dao.DaoSolicitud;
import com.ceiba.alquiler.puerto.repositorio.RepositorioProducto;
import com.ceiba.alquiler.puerto.repositorio.RepositorioSolicitud;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearSolicitudTest {

    Solicitud solicitud;

    public ServicioCrearSolicitudTest() {
        LocalDate localDate = ParseoDeFechas("2021-06-12");
        this.solicitud = new Solicitud(null,12345, 12345, localDate, 5, null,null,null);
    }

    @Test
    public void crearSolicitudCorrectamenteTest() {
        //Configuracion para el Test
        RepositorioSolicitud repositorioSolicitud = Mockito.mock(RepositorioSolicitud.class);
        Mockito.when(repositorioSolicitud.crear(this.solicitud)).thenReturn(1);

        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.buscarProductoPorId(this.solicitud.getIdProducto())).thenReturn(new Producto(
                1,
                "12345",
                "hola",
                20,
                5
        ));

        LocalDate fechaSolicitud = ParseoDeFechas("2021-06-12");
        LocalDate fechaDevolucion = ParseoDeFechas("2021-06-21");
        DaoSolicitud daoSolicitud = Mockito.mock(DaoSolicitud.class);
        Mockito.when(daoSolicitud.consultarSolicitud(1)).thenReturn(new Solicitud(
                1,
                1,
                1,
                fechaSolicitud,
                7,
                fechaDevolucion,
                175000.0,
                35000.0

        ));
        //Ejecuccion del Test
        String respuesta = new ServicioCrearSolicitud(repositorioSolicitud,repositorioProducto,daoSolicitud).ejecutar(this.solicitud);
        //Validacion del Test
        assertEquals("Se ha creado la solicitud correctamente - fecha devolucion: 2021-06-21, valor de la solicitud: 175000.0, valor del deposito: 35000.0", respuesta);
    }

    @Test
    public void productoSinCantidadesDisponiblesTest() {
        //Configuracion para el Test
        RepositorioSolicitud repositorioSolicitud = Mockito.mock(RepositorioSolicitud.class);
        Mockito.when(repositorioSolicitud.crear(this.solicitud)).thenReturn(1);

        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.buscarProductoPorId(this.solicitud.getIdProducto())).thenReturn(new Producto(
                1,
                "12345",
                "hola",
                20,
                20
        ));

        LocalDate fechaSolicitud = ParseoDeFechas("2021-06-12");
        LocalDate fechaDevolucion = ParseoDeFechas("2021-06-21");
        DaoSolicitud daoSolicitud = Mockito.mock(DaoSolicitud.class);
        Mockito.when(daoSolicitud.consultarSolicitud(1)).thenReturn(new Solicitud(
                1,
                1,
                1,
                fechaSolicitud,
                7,
                fechaDevolucion,
                175000.0,
                35000.0

        ));
        //Ejecuccion del Test
        String respuesta = new ServicioCrearSolicitud(repositorioSolicitud,repositorioProducto,daoSolicitud).ejecutar(this.solicitud);
        //Validacion del Test
        assertEquals("Error: El producto no cuenta con cantidades disponibles o no existe en el sistema", respuesta);
    }

    @Test
    public void productoPorFueraDelMinimoDeDiasTest() {
        //Configuracion para el Test

        LocalDate fechaSolicitud = ParseoDeFechas("2021-06-11");
        LocalDate fechaDevolucion = ParseoDeFechas("2021-06-21");
        Solicitud solicitudFallida = new Solicitud(null,12345, 12345, fechaSolicitud, 5, null,null,null);

        RepositorioSolicitud repositorioSolicitud = Mockito.mock(RepositorioSolicitud.class);
        Mockito.when(repositorioSolicitud.crear(solicitudFallida)).thenReturn(1);

        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.buscarProductoPorId(solicitudFallida.getIdProducto())).thenReturn(new Producto(
                1,
                "12345",
                "hola",
                20,
                5
        ));


        DaoSolicitud daoSolicitud = Mockito.mock(DaoSolicitud.class);
        Mockito.when(daoSolicitud.consultarSolicitud(1)).thenReturn(new Solicitud(
                1,
                1,
                1,
                fechaSolicitud,
                5,
                fechaDevolucion,
                175000.0,
                35000.0

        ));
        //Ejecuccion del Test
        String respuesta = new ServicioCrearSolicitud(repositorioSolicitud,repositorioProducto,daoSolicitud).ejecutar(solicitudFallida);
        //Validacion del Test
        assertEquals("Error: La solicitud se debe hacer con minímo uno  y maximo tres días de anticipación", respuesta);
    }

    @Test
    public void productoPorFueraDelTiempoPermitidoTest() {
        //Configuracion para el Test

        LocalDate fechaSolicitud = ParseoDeFechas("2021-06-12");
        LocalDate fechaDevolucion = ParseoDeFechas("2021-06-21");
        Solicitud solicitudFallida = new Solicitud(null,12345, 12345, fechaSolicitud, 8, null,null,null);

        RepositorioSolicitud repositorioSolicitud = Mockito.mock(RepositorioSolicitud.class);
        Mockito.when(repositorioSolicitud.crear(solicitudFallida)).thenReturn(1);

        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.buscarProductoPorId(solicitudFallida.getIdProducto())).thenReturn(new Producto(
                1,
                "12345",
                "hola",
                20,
                5
        ));


        DaoSolicitud daoSolicitud = Mockito.mock(DaoSolicitud.class);
        Mockito.when(daoSolicitud.consultarSolicitud(1)).thenReturn(new Solicitud(
                1,
                1,
                1,
                fechaSolicitud,
                8,
                fechaDevolucion,
                175000.0,
                35000.0

        ));
        //Ejecuccion del Test
        String respuesta = new ServicioCrearSolicitud(repositorioSolicitud,repositorioProducto,daoSolicitud).ejecutar(solicitudFallida);
        //Validacion del Test
        assertEquals("Error: Los días de alquiler es de 3 a 7", respuesta);
    }


    private LocalDate ParseoDeFechas(String fecha){
        return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}