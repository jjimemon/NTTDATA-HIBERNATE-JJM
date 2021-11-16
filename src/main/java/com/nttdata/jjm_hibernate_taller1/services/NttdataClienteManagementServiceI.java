package com.nttdata.jjm_hibernate_taller1.services;

import java.util.List;

import com.nttdata.jjm_hibernate_taller1.persistence.NttdataCliente;

/**
 * Ejercicio - Hibernate - taller 1 y 2
 * 
 * Interfaz del servicio de cliente.
 * 
 * @author Javier Jiménez Montesino
 *
 */

public interface NttdataClienteManagementServiceI {
	/**
	 * Inserta un nuevo contrato.
	 * 
	 * @param newPlayer
	 */
	public void insertNewClient(final NttdataCliente cliente);

	/**
	 * inserta un cliente
	 * 
	 * @param updatedPlayer
	 */
	public void updateClient(final NttdataCliente cliente);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param deletedPlayer
	 */
	public void deleteClient(final NttdataCliente cliente);

	/**
	 * elimina un cliente existente.
	 * 
	 * @param playerId
	 */
	public NttdataCliente searchById(final Integer clientId);

	/**
	 * Obtiene todos los clientes existentes.
	 * 
	 * @return List<NttdataCliente>
	 */
	public List<NttdataCliente> searchAll();

	public List<NttdataCliente> searchByNameAndLastname(final String patterName, final String patterLastname);

}
