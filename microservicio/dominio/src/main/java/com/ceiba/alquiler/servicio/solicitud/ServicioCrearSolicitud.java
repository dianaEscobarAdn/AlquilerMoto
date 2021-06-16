package com.ceiba.alquiler.servicio.solicitud;

import com.ceiba.alquiler.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.alquiler.modelo.dto.DtoRespuestaSolicitud;
import com.ceiba.alquiler.modelo.entidad.Producto;
import com.ceiba.alquiler.modelo.entidad.Solicitud;
import com.ceiba.alquiler.puerto.repositorio.RepositorioProducto;
import com.ceiba.alquiler.puerto.repositorio.RepositorioSolicitud;

public class ServicioCrearSolicitud {
    private RepositorioSolicitud repositorioSolicitud;
    private RepositorioProducto repositorioProducto;
    private static final String PRODUCTO_SIN_CANTIDADES_DISPONIBLES = "El producto no cuenta con cantidades disponibles o no ha sido creado";
    public ServicioCrearSolicitud(RepositorioSolicitud repositorioSolicitud, RepositorioProducto repositorioProducto) {
        this.repositorioSolicitud = repositorioSolicitud;
        this.repositorioProducto = repositorioProducto;
    }

    public DtoRespuestaSolicitud ejecutar(Solicitud solicitud) {
        if (!tieneCantidadesDisponiblesPorProducto(solicitud.getIdProducto())) {
            throw new ExcepcionValorInvalido(PRODUCTO_SIN_CANTIDADES_DISPONIBLES);
        }
        Integer idSolicitud = this.repositorioSolicitud.crear(solicitud);
        Solicitud solicitudCreada = this.repositorioSolicitud.buscarSolicitudPorId(idSolicitud);
        DtoRespuestaSolicitud dtoRespuestaSolicitud = convertirADtoRespuesta(solicitudCreada);
        buscarYActualizarCantidadesDelproducto(solicitud.getIdProducto());
        return dtoRespuestaSolicitud;
    }

    private boolean tieneCantidadesDisponiblesPorProducto(int idProducto) {
        Producto cantidadDisponible = this.repositorioProducto.buscarProductoPorId(idProducto);
        return cantidadDisponible != null && cantidadDisponible.getUnidadesComprometidas() < cantidadDisponible.getUnidadesDisponibles() ? true : false;
    }

    private Integer buscarYActualizarCantidadesDelproducto(int idProducto) {
        Producto cantidadDisponible = this.repositorioProducto.buscarProductoPorId(idProducto);
        Integer cantidadTotal = cantidadDisponible != null ? (cantidadDisponible.getUnidadesComprometidas() + 1) : 0;
        if (cantidadTotal != 0) {
            cantidadDisponible.setUnidadesComprometidas(cantidadTotal);
            this.repositorioProducto.actualizar(cantidadDisponible);
        }
        return cantidadTotal;
    }

    public DtoRespuestaSolicitud convertirADtoRespuesta (Solicitud solicitudCreada){
        return solicitudCreada != null ? new DtoRespuestaSolicitud(
                solicitudCreada.getIdSolicitud(),
                solicitudCreada.getIdProducto(),
                solicitudCreada.getIdPersona(),
                solicitudCreada.getFechaSolicitud(),
                solicitudCreada.getDiasAlquiler(),
                solicitudCreada.getFechaDevolucion(),
                solicitudCreada.getValorSolicitud(),
                solicitudCreada.getValorDeposito()
        ) : null;
    }
}