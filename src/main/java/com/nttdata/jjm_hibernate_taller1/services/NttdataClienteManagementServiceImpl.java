package com.nttdata.jjm_hibernate_taller1.services;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.jjm_hibernate_taller1.persistence.NttdataCliente;
import com.nttdata.jjm_hibernate_taller1.persistence.NttdataClienteDaoI;
import com.nttdata.jjm_hibernate_taller1.persistence.NttdataClienteDaoImpl;

/**
 * Ejercicio - Hibernate - taller 1 y 2
 * 
 * Implementación del servicio de cliente.
 * 
 * @author Javier Jiménez Montesino
 *
 */
public class NttdataClienteManagementServiceImpl implements NttdataClienteManagementServiceI {

	/** DAO: CLIENTE */
	private NttdataClienteDaoI clientDao;

	/**
	 * Método constructor.
	 */
	public NttdataClienteManagementServiceImpl(final Session session) {
		this.clientDao = new NttdataClienteDaoImpl(session);
	}

	@Override
	public void insertNewClient(NttdataCliente cliente) {

		// Verificación de nulidad e inexistencia.
		if (cliente != null && cliente.getidentificadorCliente() == null) {

			clientDao.insert(cliente);

		}

	}

	@Override
	public void updateClient(NttdataCliente cliente) {

		if (cliente != null && cliente.getidentificadorCliente() != null) {

			clientDao.update(cliente);

		}

	}

	@Override
	public void deleteClient(NttdataCliente cliente) {

		if (cliente != null && cliente.getidentificadorCliente() != null) {

			clientDao.delete(cliente);

		}

	}

	@Override
	public NttdataCliente searchById(Integer id) {

		// Resultado.
		NttdataCliente contract = null;

		// Verificación de nulidad.
		if (id != null) {

			// Obtención del cliente por ID.
			contract = clientDao.searchById(id);
		}
		return contract;
	}

	@Override
	public List<NttdataCliente> searchAll() {
		// Resultado.
		List<NttdataCliente> clientList = new ArrayList<NttdataCliente>();

		// Obtención de contratos.
		clientList = clientDao.searchAll();
		return clientList;
	}

	@Override
	public List<NttdataCliente> searchByNameAndLastname(String patterName, String patterLastname) {

		List<NttdataCliente> clientListByNameAndLastname = new ArrayList<NttdataCliente>();

		clientListByNameAndLastname = clientDao.searchByNameAndLastname(patterName, patterLastname);

		return clientListByNameAndLastname;

	}

}
