package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Producto;
import com.ceiba.alquiler.modelo.entidad.Solicitud;
import com.ceiba.alquiler.puerto.dao.DaoSolicitud;
import com.ceiba.alquiler.puerto.repositorio.RepositorioProducto;
import com.ceiba.alquiler.puerto.repositorio.RepositorioSolicitud;

import java.time.DayOfWeek;
import java.time.LocalDate;


public class ServicioCrearSolicitud {
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
        Integer idSolicitud = this.repositorioSolicitud.crear(solicitud);
        Solicitud solicitudCreada = this.daoSolicitud.consultarSolicitud(idSolicitud);
        BuscarYActualizarCantidadesDelproducto(solicitud.getIdProducto());
        return "Se ha creado la solicitud correctamente - fecha devolucion: " + solicitudCreada.getFechaDevolucion()
                + ", valor de la solicitud: " + solicitudCreada.getValorSolicitud() + ", valor del deposito: " + solicitudCreada.getValorDeposito();
    }

    private boolean tieneCantidadesDisponiblesPorProducto(int idProducto) {
        Producto cantidadDisponible = this.repositorioProducto.buscarProductoPorId(idProducto);
        return cantidadDisponible != null && cantidadDisponible.getUnidadesComprometidas() < cantidadDisponible.getUnidadesDisponibles() ? true : false;
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
