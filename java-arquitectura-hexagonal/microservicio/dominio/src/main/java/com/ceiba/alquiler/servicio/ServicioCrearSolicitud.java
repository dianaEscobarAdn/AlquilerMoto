package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Producto;
import com.ceiba.alquiler.modelo.entidad.Solicitud;
import com.ceiba.alquiler.puerto.dao.DaoSolicitud;
import com.ceiba.alquiler.puerto.repositorio.RepositorioProducto;
import com.ceiba.alquiler.puerto.repositorio.RepositorioSolicitud;

import java.time.DayOfWeek;
import java.time.LocalDate;


public class ServicioCrearSolicitud {
    public static final double VALOR_POR_DIA_DEL_ALQUILER = 25000.00;
    public static final double VALOR_POR_DIA_DEL_DEPOSITO = 5000.00;
    public static final int DIAS_MINIMOS_DEL_ALQUILER = 3;
    public static final int DIAS_MAXIMOS_DEL_ALQUILER = 7;
    public static final int DIAS_MAXIMOS_DE_ANTICIPACION = 3;
    public static final int DIAS_MINIMOS_DE_ANTICIPACION = 1;
    private RepositorioSolicitud repositorioSolicitud;
    private RepositorioProducto repositorioProducto;
    private DaoSolicitud daoSolicitud;

    public ServicioCrearSolicitud(RepositorioSolicitud repositorioSolicitud, RepositorioProducto repositorioProducto, DaoSolicitud daoSolicitud) {
        this.repositorioSolicitud = repositorioSolicitud;
        this.repositorioProducto = repositorioProducto;
        this.daoSolicitud = daoSolicitud;
    }

    public String ejecutar(Solicitud solicitud) {
        if (!tieneCantidadesDisponiblesPorProducto(solicitud.getIdProducto())) {
            return "Error: El producto no cuenta con cantidades disponibles o no existe en el sistema";
        }
        if (!estaDentroDelMinimoDeDias(solicitud.getFechaSolicitud()) || !estaDentroDelMaximoDeDias(solicitud.getFechaSolicitud())) {
            return "Error: La solicitud se debe hacer con minímo uno  y maximo tres días de anticipación";
        }
        if (!estaDentroDelTiempoPermitido(solicitud.getDiasAlquiler())) {
            return "Error: Los días de alquiler es de 3 a 7";
        }
        solicitud.setValorSolicitud(calcularValorDelAlquiler(solicitud.getDiasAlquiler()));
        solicitud.setValorDeposito(calcularValorDelDeposito(solicitud.getDiasAlquiler()));
        solicitud.setFechaDevolucion(calcularFechaMaximaDevolucion(solicitud.getDiasAlquiler(), solicitud.getFechaSolicitud()));
        Integer idSolicitud = this.repositorioSolicitud.crear(solicitud);
        Solicitud solicitudCreada = this.daoSolicitud.consultarSolicitud(idSolicitud);
        BuscarYActualizarCantidadesDelproducto(solicitud.getIdProducto());
        return "Se ha creado la solicitud correctamente - fecha devolucion: " + solicitudCreada.getFechaDevolucion()
                + ", valor de la solicitud: " + solicitudCreada.getValorSolicitud() + ", valor del deposito: " + solicitudCreada.getValorDeposito();
    }

    private boolean tieneCantidadesDisponiblesPorProducto(int idProducto) {
        Producto cantidadDisponible = this.repositorioProducto.buscarProductoPorId(idProducto);
        return cantidadDisponible != null &&
                cantidadDisponible.getUnidadesComprometidas() < cantidadDisponible.getUnidadesDisponibles() ? true : false;
    }

    private boolean estaDentroDelMinimoDeDias(LocalDate fechaSolicitud) {
        LocalDate fechaActual = LocalDate.now();
        fechaSolicitud = fechaSolicitud.plusDays(-DIAS_MINIMOS_DE_ANTICIPACION);
        return fechaActual.isEqual(fechaSolicitud) || fechaActual.isBefore(fechaSolicitud) ? true : false;
    }

    private boolean estaDentroDelMaximoDeDias(LocalDate fechaSolicitud) {
        LocalDate fechaActual = LocalDate.now();
        fechaSolicitud = fechaSolicitud.plusDays(-DIAS_MAXIMOS_DE_ANTICIPACION);
        return fechaActual.isEqual(fechaSolicitud) || fechaActual.isAfter(fechaSolicitud) ? true : false;
    }

    private boolean estaDentroDelTiempoPermitido(Integer dias) {
        return dias >= DIAS_MINIMOS_DEL_ALQUILER && dias <= DIAS_MAXIMOS_DEL_ALQUILER ? true : false;
    }

    private Double calcularValorDelAlquiler(Integer dias) {
        return VALOR_POR_DIA_DEL_ALQUILER * dias;
    }

    private Double calcularValorDelDeposito(Integer dias) {
        return VALOR_POR_DIA_DEL_DEPOSITO * dias;
    }

    private LocalDate calcularFechaMaximaDevolucion(int dias, LocalDate fechaSolicitud) {
        LocalDate result = fechaSolicitud;
        int diasFestivos = 0;
        while (diasFestivos < dias) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++diasFestivos;
            }
        }
        return result;
    }

    private Integer BuscarYActualizarCantidadesDelproducto(int idProducto) {
        Producto cantidadDisponible = this.repositorioProducto.buscarProductoPorId(idProducto);
        Integer cantidadTotal = cantidadDisponible != null ? cantidadDisponible.getUnidadesComprometidas() + 1 : 0;
        if (cantidadTotal != 0) {
            cantidadDisponible.setUnidadesComprometidas(cantidadTotal);
            this.repositorioProducto.crear(cantidadDisponible);
        }
        return cantidadTotal;
    }
}
