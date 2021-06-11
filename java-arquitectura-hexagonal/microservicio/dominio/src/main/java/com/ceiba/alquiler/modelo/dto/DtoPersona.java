package com.ceiba.alquiler.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPersona {
    private Integer idPersona;
    private int cedula;
    private String nombre;
    private String apellido;
    private int telefono;
    private String direccion;
}
