package com.ceiba.alquiler.persistencia.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "solicitud")
@Entity
@Getter
@Setter
@AllArgsConstructor
public class EntidadSolicitud {
    @Id
    @Column(name = "idsolicitud", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSolicitud;

    @Column(name = "idproducto", nullable = false)
    private Integer idProducto;

    @Column(name = "idpersona", nullable = false)
    private Integer idPersona;

    @Column(name = "fechasolicitud", nullable = false)
    private LocalDate fechaSolicitud;

    @Column(name = "diasalquiler", nullable = false)
    private Integer diasAlquiler;

    @Column(name = "fechadevolucion", nullable = false)
    private LocalDate fechaDevolucion;

    @Column(name = "valorsolicitud", nullable = false)
    private Double valorSolicitud;

    @Column(name = "valordeposito", nullable = false)
    private Double valorDeposito;

    public EntidadSolicitud(int idProducto, int idPersona, LocalDate fechaSolicitud, int diasAlquiler,LocalDate fechaDevolucion, Double valorSolicitud,Double valorDeposito) {
        this.idProducto = idProducto;
        this.idPersona = idPersona;
        this.fechaSolicitud = fechaSolicitud;
        this.diasAlquiler = diasAlquiler;
        this.fechaDevolucion = fechaDevolucion;
        this.valorSolicitud = valorSolicitud;
        this.valorDeposito = valorDeposito;
    }

    public EntidadSolicitud() {
    }
}
