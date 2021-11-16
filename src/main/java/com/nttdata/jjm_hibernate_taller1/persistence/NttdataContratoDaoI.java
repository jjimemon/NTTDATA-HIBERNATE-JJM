package com.nttdata.jjm_hibernate_taller1.persistence;

import java.util.List;

/**
 * Ejercicio - Hibernate - taller 1 y 2
 * 
 * Contrato Dao Interfaz.
 * 
 * @author Javier Jiménez Montesino
 *
 */
public interface NttdataContratoDaoI extends CommonDaoI<NttdataContrato> {

	public List<NttdataContrato> searchByIDCliente(Integer identificadorCliente);
}
