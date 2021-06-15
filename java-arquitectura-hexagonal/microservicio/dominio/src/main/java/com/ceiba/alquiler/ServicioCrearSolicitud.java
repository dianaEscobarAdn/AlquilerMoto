package com.ceiba.alquiler;

import com.ceiba.alquiler.modelo.dto.DtoSolicitud;
import com.ceiba.alquiler.modelo.entidad.Producto;
import com.ceiba.alquiler.modelo.entidad.Solicitud;
import com.ceiba.alquiler.puerto.dao.DaoSolicitud;
import com.ceiba.alquiler.puerto.repositorio.RepositorioProducto;
import com.ceiba.alquiler.puerto.repositorio.RepositorioSolicitud;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;


public class ServicioCrearSolicitud {
    private RepositorioSolicitud repositorioSolicitud;
    private RepositorioProducto repositorioProducto;
    private DaoSolicitud daoSolicitud;

    public ServicioCrearSolicitud(RepositorioSolicitud repositorioSolicitud, RepositorioProducto repositorioProducto, DaoSolicitud daoSolicitud) {
        this.repositorioSolicitud = repositorioSolicitud;
        this.repositorioProducto = repositorioProducto;
        this.daoSolicitud = daoSolicitud;
    }

    public Integer ejecutar(Solicitud solicitud) {
        if (!tieneCantidadesDisponiblesPorProducto(solicitud.getIdProducto())) {
            return solicitud.getIdSolicitud();
        }
        Integer idSolicitud = this.repositorioSolicitud.crear(solicitud);
        //DtoSolicitud solicitudCreada = this.daoSolicitud.consultarSolicitud(idSolicitud);
        BuscarYActualizarCantidadesDelproducto(solicitud.getIdProducto());
        return idSolicitud;
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
            this.repositorioProducto.actualizar(cantidadDisponible);
        }
        return cantidadTotal;
    }
}
