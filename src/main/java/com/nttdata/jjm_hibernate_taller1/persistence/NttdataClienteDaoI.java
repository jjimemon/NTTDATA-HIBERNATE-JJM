package com.nttdata.jjm_hibernate_taller1.persistence;

import java.util.List;

/**
 * Ejercicio - Hibernate - taller 1 y 2
 * 
 * Cliente Dao Interface.
 * 
 * @author Javier Jiménez Montesino
 *
 */
public interface NttdataClienteDaoI extends CommonDaoI<NttdataCliente> {

	/*
	 * Método propio, realiza una busqueda por nombre y apellido en la BBDD.
	 */
	public List<NttdataCliente> searchByNameAndLastname(final String patterName, final String patterLastName);
}
