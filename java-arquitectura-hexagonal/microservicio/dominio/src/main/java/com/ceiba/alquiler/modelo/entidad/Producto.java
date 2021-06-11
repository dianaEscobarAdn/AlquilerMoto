package com.ceiba.alquiler.modelo.entidad;

import com.ceiba.alquiler.dominio.ValidadorArgumento;

public class Producto {

    private static final String SE_DEBE_INGRESAR_EL_CODIGO = "Se debe ingresar el codigo del producto";
    private static final String SE_DEBE_INGRESAR_LA_DESCRIPCION = "Se debe ingresar la descripcion del producto";
    private static final String SE_DEBE_INGRESAR_LAS_UNIDADES_DISPONIBLES = "Se debe ingresar las unidades disponibles del producto";
    private static final String SE_DEBE_INGRESAR_LAS_UNIDADES_COMPROMETIDAS = "Se debe ingresar las unidades comprometidas del producto";
    private static final String UNIDADES_COMPROMETIDAS_MAYOR_A_LAS_SOLICITADAS = "Las unidades comprometidas no puede ser mayor a las unidades disponibles";

    private Integer idProducto;
    private String codigoProducto;
    private String descripcionProducto;
    private int unidadesDisponibles;
    private int unidadesComprometidas;

    public Producto(Integer idProducto, String codigoProducto, String descripcionProducto, int unidadesDisponibles, int unidadesComprometidas) {
        ValidadorArgumento.validarObligatorio(codigoProducto, SE_DEBE_INGRESAR_EL_CODIGO);
        ValidadorArgumento.validarObligatorio(descripcionProducto, SE_DEBE_INGRESAR_LA_DESCRIPCION);
        ValidadorArgumento.validarObligatorio(unidadesDisponibles, SE_DEBE_INGRESAR_LAS_UNIDADES_DISPONIBLES);
        ValidadorArgumento.validarObligatorio(unidadesComprometidas, SE_DEBE_INGRESAR_LAS_UNIDADES_COMPROMETIDAS);
        ValidadorArgumento.validarUnidadesDisponiblesContraUnidadesComprometidas(unidadesComprometidas,unidadesDisponibles, UNIDADES_COMPROMETIDAS_MAYOR_A_LAS_SOLICITADAS);

        this.idProducto = idProducto;
        this.codigoProducto = codigoProducto;
        this.descripcionProducto = descripcionProducto;
        this.unidadesDisponibles = unidadesDisponibles;
        this.unidadesComprometidas = unidadesComprometidas;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public int getUnidadesComprometidas() {return unidadesComprometidas;    }

    public void setUnidadesComprometidas(int unidadesComprometidas) { this.unidadesComprometidas = unidadesComprometidas; }
}
