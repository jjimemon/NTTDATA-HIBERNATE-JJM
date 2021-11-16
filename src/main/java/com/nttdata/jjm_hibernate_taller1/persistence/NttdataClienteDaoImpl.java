package com.nttdata.jjm_hibernate_taller1.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * Ejercicio - Hibernate - taller 1 y 2
 * 
 * Cliente Dao Implementación.
 * 
 * @author Javier Jiménez Montesino
 *
 */

public class NttdataClienteDaoImpl extends CommonDaoImpl<NttdataCliente> implements NttdataClienteDaoI {

	/** Sesión de conexión a BD. */
	private Session session;

	/**
	 * Método constructor que recibe la sesión.
	 */
	public NttdataClienteDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	/*
	 * @param patterName, patterLastName
	 * 
	 * @Return List<NttdataCliente>
	 */
	@Override
	public List<NttdataCliente> searchByNameAndLastname(final String patterName, final String patterLastName) {

		// Búsqueda por nombre y apellido aplicando JPA CRITERIA
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<NttdataCliente> cQuery = cb.createQuery(NttdataCliente.class);
		final Root<NttdataCliente> rootP = cQuery.from(NttdataCliente.class);
		final Join<NttdataCliente, NttdataContrato> pJoinT = rootP.join("contratos");

		final Predicate pr1 = cb.like(pJoinT.getParent().<String>get("nombre"), patterName);
		final Predicate pr2 = cb.like(pJoinT.getParent().<String>get("apellido"), patterLastName);

		cQuery.select(rootP).where(cb.and(pr1, pr2));

		final List<NttdataCliente> results = session.createQuery(cQuery).getResultList();

		return results;
	}
}
