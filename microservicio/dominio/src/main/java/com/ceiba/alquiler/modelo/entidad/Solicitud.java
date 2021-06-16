package com.ceiba.alquiler.modelo.entidad;

import com.ceiba.alquiler.dominio.ValidadorArgumento;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Solicitud {

    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_PRODUTO = "Se debe ingresar el id del producto";
    private static final String SE_DEBE_INGRESAR_EL_ID_DE_LA_PERSONA = "Se debe ingresar el id de la persona";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_SOLICITUD = "Se debe ingresar la fecha de solicitud";
    private static final String SE_DEBE_INGRESAR_LOS_DIAS_DEL_ALQUILER = "Se debe ingresar los días del alquiler";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_DEVOLUCION = "Se debe ingresar la fecha de devolucion";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_DEL_ALQUILER = "Se debe ingresar el valor del alquiler";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_DEL_DEPOSITO = "Se debe ingresar el valor del deposito";
    private static final String POR_FUERA_RANGO_DE_FECHA_PARA_SOLICITAR = "La solicitud se debe hacer con minímo uno  y maximo tres días de anticipación";
    private static final String POR_FUERA_RANGO_DE_DIAS_DE_LA_SOLICITUD = "Error: Los días de alquiler es de 3 a 7";
    private static final double VALOR_POR_DIA_DEL_ALQUILER = 25000.00;
    private static final double VALOR_POR_DIA_DEL_DEPOSITO = 5000.00;

    private Integer idSolicitud;
    private Integer idProducto;
    private Integer idPersona;
    private LocalDate fechaSolicitud;
    private Integer diasAlquiler;
    private LocalDate fechaDevolucion;
    private Double valorSolicitud;
    private Double valorDeposito;

    public Solicitud(Integer idSolicitud, Integer idProducto, Integer idPersona, LocalDate fechaSolicitud, Integer diasAlquiler) {
        ValidadorArgumento.validarObligatorio(idProducto, SE_DEBE_INGRESAR_EL_ID_DEL_PRODUTO);
        ValidadorArgumento.validarObligatorio(idPersona, SE_DEBE_INGRESAR_EL_ID_DE_LA_PERSONA);
        ValidadorArgumento.validarObligatorio(fechaSolicitud, SE_DEBE_INGRESAR_LA_FECHA_DE_SOLICITUD);
        ValidadorArgumento.validarObligatorio(diasAlquiler, SE_DEBE_INGRESAR_LOS_DIAS_DEL_ALQUILER);
        ValidadorArgumento.estaDentroDelMinimoDeDias(fechaSolicitud, POR_FUERA_RANGO_DE_FECHA_PARA_SOLICITAR);
        ValidadorArgumento.estaDentroDelMaximoDeDias(fechaSolicitud, POR_FUERA_RANGO_DE_FECHA_PARA_SOLICITAR);
        ValidadorArgumento.estaDentroDelTiempoPermitido(diasAlquiler, POR_FUERA_RANGO_DE_DIAS_DE_LA_SOLICITUD);

        this.idSolicitud = idSolicitud;
        this.idProducto = idProducto;
        this.idPersona = idPersona;
        this.fechaSolicitud = fechaSolicitud;
        this.diasAlquiler = diasAlquiler;
        this.fechaDevolucion = this.calcularFechaMaximaDevolucion();
        this.valorSolicitud = this.calcularValorDelAlquiler();
        this.valorDeposito = this.calcularValorDelDeposito();
    }

    public Solicitud(Integer idSolicitud, Integer idProducto, Integer idPersona, LocalDate fechaSolicitud, Integer diasAlquiler, LocalDate fechaDevolucion, Double valorSolicitud, Double valorDeposito) {
        ValidadorArgumento.validarObligatorio(idProducto, SE_DEBE_INGRESAR_EL_ID_DEL_PRODUTO);
        ValidadorArgumento.validarObligatorio(idPersona, SE_DEBE_INGRESAR_EL_ID_DE_LA_PERSONA);
        ValidadorArgumento.validarObligatorio(fechaSolicitud, SE_DEBE_INGRESAR_LA_FECHA_DE_SOLICITUD);
        ValidadorArgumento.validarObligatorio(diasAlquiler, SE_DEBE_INGRESAR_LOS_DIAS_DEL_ALQUILER);
        ValidadorArgumento.estaDentroDelMinimoDeDias(fechaSolicitud, POR_FUERA_RANGO_DE_FECHA_PARA_SOLICITAR);
        ValidadorArgumento.estaDentroDelMaximoDeDias(fechaSolicitud, POR_FUERA_RANGO_DE_FECHA_PARA_SOLICITAR);
        ValidadorArgumento.estaDentroDelTiempoPermitido(diasAlquiler, POR_FUERA_RANGO_DE_DIAS_DE_LA_SOLICITUD);
        ValidadorArgumento.validarObligatorio(fechaDevolucion, SE_DEBE_INGRESAR_LA_FECHA_DE_DEVOLUCION);
        ValidadorArgumento.validarObligatorio(valorSolicitud, SE_DEBE_INGRESAR_EL_VALOR_DEL_ALQUILER);
        ValidadorArgumento.validarObligatorio(valorDeposito, SE_DEBE_INGRESAR_EL_VALOR_DEL_DEPOSITO);

        this.idSolicitud = idSolicitud;
        this.idProducto = idProducto;
        this.idPersona = idPersona;
        this.fechaSolicitud = fechaSolicitud;
        this.diasAlquiler = diasAlquiler;
        this.fechaDevolucion = fechaDevolucion;
        this.valorSolicitud = valorSolicitud;
        this.valorDeposito = valorDeposito;
    }

    private Double calcularValorDelAlquiler() {
        return VALOR_POR_DIA_DEL_ALQUILER * this.diasAlquiler;
    }

    private Double calcularValorDelDeposito() {
        return VALOR_POR_DIA_DEL_DEPOSITO * this.diasAlquiler;
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

    private LocalDate calcularFechaMaximaDevolucion() {
        LocalDate result = this.fechaSolicitud;
        int diasFestivos = 0;
        while (diasFestivos < this.diasAlquiler) {
            result = result.plusDays(1);
            if (result.getDayOfWeek() != DayOfWeek.SUNDAY) {
                ++diasFestivos;
            }
        }
        return result;
    }
}