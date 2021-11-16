package com.nttdata.jjm_hibernate_taller1;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Ejercicio - Hibernate - taller 1 y 2.
 * 
 * Clase destinada a la configuración.
 * 
 * @author Javier Jiménez Montesinos.
 *
 */
public class NttdataHibernateUtil {

	/** sesiones */
	private static final SessionFactory SESSION_FACTORY;

	/**
	 * Generación de sesiones.
	 */
	static {

		try {

			// Generador de configuración.
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

		} catch (final Throwable exception) {

			// Error al inicializar.
			System.err.println("[ERROR] Configuración de Hibernate - " + exception);
			throw new ExceptionInInitializerError();
		}

	}

	/**
	 * Retorna la factoría de sesiones.
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}
