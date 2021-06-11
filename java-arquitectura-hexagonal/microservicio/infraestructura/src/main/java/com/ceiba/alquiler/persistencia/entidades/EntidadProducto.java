package com.ceiba.alquiler.persistencia.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "producto")
@Entity
@Getter
@Setter
@AllArgsConstructor
public class EntidadProducto {
    @Id
    @Column(name = "idproducto", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @Column(name = "codigoproducto", nullable = false)
    private String codigoProducto;

    @Column(name = "descripcionproducto", nullable = false)
    private String descripcionProducto;

    @Column(name = "unidadesdisponibles", nullable = false)
    private Integer unidadesDisponibles;

    @Column(name = "unidadescomprometidas", nullable = false)
    private Integer unidadesComprometidas;

    public EntidadProducto(String codigoProducto, String descripcionProducto, int unidadesDisponibles, int unidadesComprometidas) {
        this.codigoProducto = codigoProducto;
        this.descripcionProducto = descripcionProducto;
        this.unidadesDisponibles = unidadesDisponibles;
        this.unidadesComprometidas = unidadesComprometidas;
    }

    public EntidadProducto() {
    }
}
