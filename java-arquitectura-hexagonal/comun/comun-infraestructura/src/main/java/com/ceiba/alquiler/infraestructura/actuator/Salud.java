package com.ceiba.alquiler.infraestructura.actuator;

import com.ceiba.alquiler.infraestructura.excepcion.ExcepcionTecnica;

/**
 * Interface que tiene por objetivo ser implementada por todos los bloques 
 * que quieran utilizar HealthCheck
 * 
 * @author sergio.villamizar
 *
 */

public interface Salud  {
	/**
	 * Registra los bloques implementados
	 */
	public void registrarBloque();
	
	/**
	 * Valida la salud del bloque
	 * @throws ExepcionBloqueSinServicio
	 */
	public void verificar() throws ExcepcionTecnica;//a�adir

}
