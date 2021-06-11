package com.ceiba.alquiler.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPersona {

    private Integer idPersona;
    private int cedula;
    private String nombre;
    private String apellido;
    private int telefono;
    private String direccion;
}
