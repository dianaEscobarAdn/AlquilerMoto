package com.ceiba.alquiler.servicio.solicitud;

import com.ceiba.alquiler.dominio.ValidadorArgumento;
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
    private static final String NO_ENCONTRO_LA_SOLICITUD_CREADA = "No encontro la solicitud creada";
    private static final String NO_ENCONTRO_EL_PRODUCTO = "No encontro el producto";
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
        buscarYActualizarCantidadesDelproducto(solicitud.getIdProducto());
        ValidadorArgumento.validarObligatorio(solicitudCreada, NO_ENCONTRO_LA_SOLICITUD_CREADA);
        return convertirADtoRespuesta(solicitudCreada);
    }

    private boolean tieneCantidadesDisponiblesPorProducto(int idProducto) {
        Producto cantidadDisponible = this.repositorioProducto.buscarProductoPorId(idProducto);
        ValidadorArgumento.validarObligatorio(cantidadDisponible, PRODUCTO_SIN_CANTIDADES_DISPONIBLES);
        return cantidadDisponible.getUnidadesComprometidas() < cantidadDisponible.getUnidadesDisponibles();
    }

    private Integer buscarYActualizarCantidadesDelproducto(int idProducto) {
        Producto cantidadDisponible = this.repositorioProducto.buscarProductoPorId(idProducto);
        ValidadorArgumento.validarObligatorio(cantidadDisponible, NO_ENCONTRO_EL_PRODUCTO);
        Integer cantidadTotal = cantidadDisponible.getUnidadesComprometidas() + 1;
        if (cantidadTotal != 0) {
            cantidadDisponible.setUnidadesComprometidas(cantidadTotal);
            this.repositorioProducto.actualizar(cantidadDisponible);
        }
        return cantidadTotal;
    }

    public DtoRespuestaSolicitud convertirADtoRespuesta (Solicitud solicitudCreada){
        return new DtoRespuestaSolicitud(
                solicitudCreada.getIdSolicitud(),
                solicitudCreada.getIdProducto(),
                solicitudCreada.getIdPersona(),
                solicitudCreada.getFechaSolicitud(),
                solicitudCreada.getDiasAlquiler(),
                solicitudCreada.getFechaDevolucion(),
                solicitudCreada.getValorSolicitud(),
                solicitudCreada.getValorDeposito()
        );
    }
}