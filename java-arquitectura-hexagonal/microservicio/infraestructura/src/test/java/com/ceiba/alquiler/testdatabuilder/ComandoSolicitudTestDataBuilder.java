package com.ceiba.alquiler.testdatabuilder;

import com.ceiba.alquiler.comando.ComandoSolicitud;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ComandoSolicitudTestDataBuilder {

    private Integer idSolicitud;
    private Integer idProducto;
    private Integer idPersona;
    private LocalDate fechaSolicitud;
    private Integer diasAlquiler;
    private LocalDate fechaDevolucion;
    private Double valorSolicitud;
    private Double valorDeposito;

    public ComandoSolicitudTestDataBuilder() {
        String fechaSolicitudes = "2021-06-12";
        LocalDate fechaSolicitudParseada = LocalDate.parse(fechaSolicitudes, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        idProducto = 12345;
        idPersona = 12345;
        fechaSolicitud = fechaSolicitudParseada;
        diasAlquiler = 7;
    }

    public ComandoSolicitudTestDataBuilder conId(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
        return this;
    }

    public ComandoSolicitud build() {
        return new ComandoSolicitud(idSolicitud,idProducto, idPersona,fechaSolicitud,diasAlquiler,fechaDevolucion,valorSolicitud,valorDeposito);
    }
}
