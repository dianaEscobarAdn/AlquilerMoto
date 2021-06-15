package com.ceiba.alquiler.modelo.entidad;

import com.ceiba.alquiler.dominio.ValidadorArgumento;

public class Persona {

    private static final String SE_DEBE_INGRESAR_LA_CEDULA_CREACION = "Se debe ingresar la cedula de creación";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_CREACION = "Se debe ingresar el nombre de creación";
    private static final String SE_DEBE_INGRESAR_EL_APELLIDO_CREACION = "Se debe ingresar el apellido de creación";
    private static final String SE_DEBE_INGRESAR_EL_TELEFONO_CREACION = "Se debe ingresar el telefono de creación";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";

    private Integer idPersona;
    private int cedula;
    private String nombre;
    private String apellido;
    private int telefono;
    private String direccion;

    public Persona(Integer idPersona, int cedula, String nombre, String apellido, int telefono, String direccion) {
        ValidadorArgumento.validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA_CREACION);
        ValidadorArgumento.validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_CREACION);
        ValidadorArgumento.validarObligatorio(apellido, SE_DEBE_INGRESAR_EL_APELLIDO_CREACION);
        ValidadorArgumento.validarObligatorio(telefono, SE_DEBE_INGRESAR_EL_TELEFONO_CREACION);
        ValidadorArgumento.validarObligatorio(direccion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

        this.idPersona = idPersona;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }
}