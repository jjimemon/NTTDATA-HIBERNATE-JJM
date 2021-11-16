package com.nttdata.jjm_hibernate_taller1.services;

import java.util.List;

import com.nttdata.jjm_hibernate_taller1.persistence.NttdataContrato;

/**
 * Ejercicio - Hibernate - taller 1 y 2
 * 
 * Interfaz del servicio de contrato.
 * 
 * @author Javier Jiménez Montesino
 *
 */
public interface NttdataContratoManagementServiceI {
	/**
	 * Inserta un nuevo contrato.
	 * 
	 * @param newPlayer
	 */
	public void insertNewContract(final NttdataContrato contract);

	/**
	 * inserta un cliente
	 * 
	 * @param updatedPlayer
	 */
	public void updateContract(final NttdataContrato contract);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param deletedPlayer
	 */
	public void deleteContract(final NttdataContrato contract);

	/**
	 * elimina un cliente existente.
	 * 
	 * @param playerId
	 */
	public NttdataContrato searchById(final Integer contract);

	/**
	 * Obtiene todos los clientes existentes.
	 * 
	 * @return List<NttdataCliente>
	 */
	public List<NttdataContrato> searchAll();

	public List<NttdataContrato> searchByIDCliente(Integer clienteID);
}
