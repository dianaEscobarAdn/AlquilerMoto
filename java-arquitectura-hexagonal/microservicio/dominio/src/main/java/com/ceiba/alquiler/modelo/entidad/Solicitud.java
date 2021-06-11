package com.ceiba.alquiler.modelo.entidad;

import com.ceiba.alquiler.dominio.ValidadorArgumento;

import java.time.LocalDate;

public class Solicitud {

    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_PRODUTO = "Se debe ingresar el id del producto";
    private static final String SE_DEBE_INGRESAR_EL_ID_DE_LA_PERSONA = "Se debe ingresar el id de la persona";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_SOLICITUD = "Se debe ingresar la fecha de solicitud";
    private static final String SE_DEBE_INGRESAR_LOS_DIAS_DEL_ALQUILER = "Se debe ingresar los días del alquiler";

    private Integer idSolicitud;
    private Integer idProducto;
    private Integer idPersona;
    private LocalDate fechaSolicitud;
    private Integer diasAlquiler;
    private LocalDate fechaDevolucion;
    private Double valorSolicitud;
    private Double valorDeposito;

    public Solicitud(Integer idSolicitud, Integer idProducto, Integer idPersona, LocalDate fechaSolicitud
                ,Integer diasAlquiler, LocalDate fechaDevolucion, Double valorSolicitud, Double valorDeposito){
        ValidadorArgumento.validarObligatorio(idProducto, SE_DEBE_INGRESAR_EL_ID_DEL_PRODUTO);
        ValidadorArgumento.validarObligatorio(idPersona, SE_DEBE_INGRESAR_EL_ID_DE_LA_PERSONA);
        ValidadorArgumento.validarObligatorio(fechaSolicitud, SE_DEBE_INGRESAR_LA_FECHA_DE_SOLICITUD);
        ValidadorArgumento.validarObligatorio(diasAlquiler, SE_DEBE_INGRESAR_LOS_DIAS_DEL_ALQUILER);


        this.idSolicitud = idSolicitud;
        this.idProducto = idProducto;
        this.idPersona = idPersona;
        this.fechaSolicitud = fechaSolicitud ;
        this.diasAlquiler = diasAlquiler;
        this.fechaDevolucion = fechaDevolucion;
        this.valorSolicitud = valorSolicitud;
        this.valorDeposito = valorDeposito;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public Integer getDiasAlquiler() {
        return diasAlquiler;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public Double getValorSolicitud() {
        return valorSolicitud;
    }

    public Double getValorDeposito() {
        return valorDeposito;
    }

    public void setFechaDevolucion(LocalDate setFechaDevolucion) {
        this.fechaDevolucion = setFechaDevolucion;
    }

    public void setValorSolicitud(Double valorSolicitud) {
        this.valorSolicitud = valorSolicitud;
    }

    public void setValorDeposito(Double valorDeposito) {
        this.valorDeposito = valorDeposito;
    }
}
