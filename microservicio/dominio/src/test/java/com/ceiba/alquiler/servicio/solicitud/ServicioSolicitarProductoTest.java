package com.ceiba.alquiler.servicio.solicitud;

import com.ceiba.alquiler.BasePrueba;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.alquiler.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.alquiler.modelo.dto.DtoRespuestaSolicitud;
import com.ceiba.alquiler.modelo.dto.DtoSolicitud;
import com.ceiba.alquiler.modelo.entidad.Producto;
import com.ceiba.alquiler.modelo.entidad.Solicitud;
import com.ceiba.alquiler.puerto.dao.DaoSolicitud;
import com.ceiba.alquiler.puerto.repositorio.RepositorioProducto;
import com.ceiba.alquiler.puerto.repositorio.RepositorioSolicitud;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioSolicitarProductoTest {

    Solicitud solicitud;

    public ServicioSolicitarProductoTest() {
        LocalDate localDate = ParseoDeFechas("2021-06-18");
        this.solicitud = new Solicitud(null,12345, 12345, localDate, 5);
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

        LocalDate fechaSolicitud = ParseoDeFechas("2021-06-18");
        LocalDate fechaDevolucion = ParseoDeFechas("2021-06-24");
        Mockito.when(repositorioSolicitud.buscarSolicitudPorId(1)).thenReturn(new Solicitud(
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
        DtoRespuestaSolicitud respuesta = new ServicioSolicitarProducto(repositorioSolicitud,repositorioProducto).ejecutar(this.solicitud);
        //Validacion del Test
        assertEquals(1, respuesta.getIdSolicitud().intValue());
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

        LocalDate fechaSolicitud = ParseoDeFechas("2021-06-18");
        LocalDate fechaDevolucion = ParseoDeFechas("2021-06-24");
        DaoSolicitud daoSolicitud = Mockito.mock(DaoSolicitud.class);
        Mockito.when(daoSolicitud.consultarSolicitud(1)).thenReturn(new DtoSolicitud(
                1,
                1,
                1,
                fechaSolicitud,
                7,
                fechaDevolucion,
                175000.0,
                35000.0

        ));
        //act - assert
        BasePrueba.assertThrows(() -> new ServicioSolicitarProducto(repositorioSolicitud,repositorioProducto).ejecutar(this.solicitud), ExcepcionValorInvalido.class,"El producto no cuenta con cantidades disponibles o no ha sido creado");
    }

    @Test
    public void crearDtoSolicitud() {
        LocalDate fechaSolicitud = ParseoDeFechas("2021-06-18");
        LocalDate fechaDevolucion = ParseoDeFechas("2021-06-24");
        DtoSolicitud solicitud = new DtoSolicitud (
                1,
                1,
                1,
                fechaSolicitud,
                1,
                fechaDevolucion,
                175000.0,
                35000.0
        );
        assertEquals(1, solicitud.getIdSolicitud().intValue());
        assertEquals(1, solicitud.getIdProducto().intValue());
        assertEquals(1, solicitud.getIdPersona().intValue());
        assertEquals(fechaSolicitud, solicitud.getFechaSolicitud());
        assertEquals(1, solicitud.getDiasAlquiler().intValue());
        assertEquals(fechaDevolucion, solicitud.getFechaDevolucion());
        assertEquals(175000.0, solicitud.getValorSolicitud().doubleValue());
        assertEquals(35000.0, solicitud.getValorDeposito().doubleValue());
    }

    @Test
    public void crearDtoRespuestaSolicitud() {
        LocalDate fechaSolicitud = ParseoDeFechas("2021-06-18");
        LocalDate fechaDevolucion = ParseoDeFechas("2021-06-24");
        DtoRespuestaSolicitud solicitud = new DtoRespuestaSolicitud (
                1,
                1,
                1,
                fechaSolicitud,
                1,
                fechaDevolucion,
                175000.0,
                35000.0
        );
        assertEquals(1, solicitud.getIdSolicitud().intValue());
        assertEquals(1, solicitud.getIdProducto().intValue());
        assertEquals(1, solicitud.getIdPersona().intValue());
        assertEquals(fechaSolicitud, solicitud.getFechaSolicitud());
        assertEquals(1, solicitud.getDiasAlquiler().intValue());
        assertEquals(fechaDevolucion, solicitud.getFechaDevolucion());
        assertEquals(175000.0, solicitud.getValorSolicitud().doubleValue());
        assertEquals(35000.0, solicitud.getValorDeposito().doubleValue());
    }

    private LocalDate ParseoDeFechas(String fecha){
        return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Test
    public void porFueraDelMinimoDeDiasTest() {
        //Configuracion para el Test
        LocalDate fechaSolicitud = ParseoDeFechas("2021-06-15");
        LocalDate fechaDevolucion = ParseoDeFechas("2021-06-24");

        //act - assert
        BasePrueba.assertThrows(() -> new Solicitud (
                1,
                1,
                1,
                fechaSolicitud,
                1,
                fechaDevolucion,
                175000.0,
                35000.0
        ), ExcepcionValorInvalido.class,"La solicitud se debe hacer con minímo uno  y maximo tres días de anticipación");
    }

    @Test
    public void porFueraDelMaximoDeDiasTest() {
        //Configuracion para el Test
        LocalDate fechaSolicitud = ParseoDeFechas("2021-06-20");
        LocalDate fechaDevolucion = ParseoDeFechas("2021-06-24");

        //act - assert
        BasePrueba.assertThrows(() -> new Solicitud (
                1,
                1,
                1,
                fechaSolicitud,
                1,
                fechaDevolucion,
                175000.0,
                35000.0
        ), ExcepcionValorInvalido.class,"La solicitud se debe hacer con minímo uno  y maximo tres días de anticipación");
    }

    @Test
    public void porFueraDelTiempoPermitidoTest() {
        //Configuracion para el Test
        LocalDate fechaSolicitud = ParseoDeFechas("2021-06-18");
        LocalDate fechaDevolucion = ParseoDeFechas("2021-06-24");

        //act - assert
        BasePrueba.assertThrows(() -> new Solicitud (
                1,
                1,
                1,
                fechaSolicitud,
                8,
                fechaDevolucion,
                175000.0,
                35000.0
        ), ExcepcionValorInvalido.class,"Error: Los días de alquiler es de 3 a 7");
    }

    @Test
    public void CampoObligatorioTest() {
        //Configuracion para el Test
        LocalDate fechaSolicitud = ParseoDeFechas("2021-06-18");
        LocalDate fechaDevolucion = ParseoDeFechas("2021-06-24");

        //act - assert
        BasePrueba.assertThrows(() -> new Solicitud (
                1,
                null,
                1,
                fechaSolicitud,
                8,
                fechaDevolucion,
                175000.0,
                35000.0
        ), ExcepcionValorObligatorio.class,"Se debe ingresar el id del producto");
    }
}