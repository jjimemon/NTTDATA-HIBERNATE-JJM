package com.nttdata.jjm_hibernate_taller1.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.jjm_hibernate_taller1.persistence.NttdataContratoDaoImpl;
import com.nttdata.jjm_hibernate_taller1.persistence.NttdataContrato;
import com.nttdata.jjm_hibernate_taller1.persistence.NttdataContratoDaoI;

/**
 * Ejercicio - Hibernate - taller 1 y 2
 * 
 * Implementación del servicio de contrato.
 * 
 * @author Javier Jiménez Montesino
 *
 */
public class NttdataContratoManagementServiceImpl implements NttdataContratoManagementServiceI {
	/** DAO: CLIENTE */
	private NttdataContratoDaoI contractDao;

	/**
	 * Método constructor.
	 */

	public NttdataContratoManagementServiceImpl(final Session session) {
		this.contractDao = new NttdataContratoDaoImpl(session);
	}

	@Override
	public void insertNewContract(NttdataContrato contract) {

		// Verificación de nulidad e inexistencia.
		if (contract != null && contract.getidentificadorContrato() == null) {

			contractDao.insert(contract);

		}

	}

	@Override
	public void updateContract(NttdataContrato contract) {

		if (contract != null && contract.getidentificadorContrato() != null) {

			contractDao.update(contract);

		}

	}

	@Override
	public void deleteContract(NttdataContrato contract) {

		if (contract != null && contract.getidentificadorContrato() != null) {

			contractDao.delete(contract);

		}

	}

	@Override
	public NttdataContrato searchById(Integer contractID) {

		// Resultado.
		NttdataContrato contract = null;

		// Verificación de nulidad.
		if (contractID != null) {

			// Obtención del cliente por ID.
			contract = contractDao.searchById(contractID);
		}
		return contract;
	}

	@Override
	public List<NttdataContrato> searchAll() {
		// Resultado.
		List<NttdataContrato> contractList = new ArrayList<NttdataContrato>();

		// Obtención de contratos.
		contractList = contractDao.searchAll();
		return contractList;
	}

	@Override
	public List<NttdataContrato> searchByIDCliente(Integer clienteID) {

		List<NttdataContrato> clientListByID = new ArrayList<NttdataContrato>();

		clientListByID = contractDao.searchByIDCliente(clienteID - 1);

		return clientListByID;

	}

}
