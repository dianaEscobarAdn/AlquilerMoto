package com.ceiba.alquiler.persistencia.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "persona")
@Entity
@Getter
@Setter
@AllArgsConstructor
public class EntidadPersona {
    @Id
    @Column(name = "idpersona", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

    @Column(name = "cedula", nullable = false)
    private int cedula;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "telefono", nullable = false)
    private int telefono;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    public EntidadPersona(int cedula, String nombre, String apellido, int telefono, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public EntidadPersona() {
    }
}
