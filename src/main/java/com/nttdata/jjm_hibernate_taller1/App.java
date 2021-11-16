package com.nttdata.jjm_hibernate_taller1;

import java.util.Date;

import org.hibernate.Session;

import com.nttdata.jjm_hibernate_taller1.persistence.NttdataCliente;
import com.nttdata.jjm_hibernate_taller1.persistence.NttdataContrato;
import com.nttdata.jjm_hibernate_taller1.services.NttdataClienteManagementServiceI;
import com.nttdata.jjm_hibernate_taller1.services.NttdataClienteManagementServiceImpl;
import com.nttdata.jjm_hibernate_taller1.services.NttdataContratoManagementServiceI;
import com.nttdata.jjm_hibernate_taller1.services.NttdataContratoManagementServiceImpl;

/*
 * Ejercicio - Hibernate - taller 1 y 2
 * 
 * Clase Main.
 * 
 * @author Javier Jiménez Montesino.
 */

public class App {
	public static void main(String[] args) {

		// Apertura de sesión.
		final Session session = NttdataHibernateUtil.getSessionFactory().openSession();

		// Auditoría.
		final String updatedUser = "JAVIER_SYS";
		final Date updatedDate = new Date();

		// Servicios

		final NttdataClienteManagementServiceI clientService = new NttdataClienteManagementServiceImpl(session);
		final NttdataContratoManagementServiceI contractService = new NttdataContratoManagementServiceImpl(session);

		// Generación de clientes.
		final NttdataCliente cliente1 = new NttdataCliente();
		cliente1.setDni("20051899B");
		cliente1.setNombre("Javier");
		cliente1.setApellido("Jiménez");
		cliente1.setApellido2("Montesinos");
		cliente1.setUpdatedDate(updatedDate);
		cliente1.setUpdatedUser(updatedUser);

		final NttdataCliente cliente2 = new NttdataCliente();
		cliente2.setDni("20052399B");
		cliente2.setNombre("Manolito");
		cliente2.setApellido("Gafota");
		cliente2.setApellido2("Gafita");
		cliente2.setUpdatedDate(updatedDate);
		cliente2.setUpdatedUser(updatedUser);

		// Generación de contratos.

		final NttdataContrato contrato1 = new NttdataContrato();
		contrato1.setCliente(cliente1);
		contrato1.setFechaCaducidad(updatedDate);
		contrato1.setFechaVigencia(updatedDate);
		contrato1.setPrecioMensual(10);
		contrato1.setUpdatedDate(updatedDate);
		contrato1.setUpdatedUser(updatedUser);

		final NttdataContrato contrato2 = new NttdataContrato();
		contrato2.setCliente(cliente2);
		contrato2.setFechaCaducidad(updatedDate);
		contrato2.setFechaVigencia(updatedDate);
		// contrato1.setIdentificadorContrato(1);
		contrato2.setPrecioMensual(10000);
		contrato2.setUpdatedDate(updatedDate);
		contrato2.setUpdatedUser(updatedUser);

		// llamada a métodos

		clientService.insertNewClient(cliente1);
		clientService.insertNewClient(cliente2);
		contractService.insertNewContract(contrato1);
		contractService.insertNewContract(contrato2);
		cliente1.setApellido("Giménez");
		contrato1.setPrecioMensual(1000);

		clientService.updateClient(cliente1);
		contractService.updateContract(contrato1);
		System.out.println(clientService.searchById(2));

		System.out.println(clientService.searchByNameAndLastname("M%", "G%"));
		System.out.println(contractService.searchByIDCliente(2));
		// Cierre de sesión.
		session.close();

	}
}
