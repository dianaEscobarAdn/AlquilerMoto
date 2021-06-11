package com.ceiba.alquiler.dominio.excepcion;

public class ExcepcionLongitudValor extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionLongitudValor(String message) {
        super(message);
    }
}
