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
 * Contrato Dao Implementación.
 * 
 * @author Javier Jiménez Montesino
 *
 */
public class NttdataContratoDaoImpl extends CommonDaoImpl<NttdataContrato> implements NttdataContratoDaoI {

	/** Sesión de conexión a BD. */
	private Session session;

	/**
	 * Método constructor que recibe la sesión.
	 */
	public NttdataContratoDaoImpl(Session session) {
		super(session);
		this.session = session;

	}

	@Override
	public List<NttdataContrato> searchByIDCliente(Integer identificadorCliente) {

		// Búsqueda por nombre y apellido aplicando JPA CRITERIA
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<NttdataContrato> cQuery = cb.createQuery(NttdataContrato.class);
		final Root<NttdataContrato> rootP = cQuery.from(NttdataContrato.class);
		final Join<NttdataContrato, NttdataCliente> pJoinT = rootP.join("cliente");

		final Predicate pr1 = cb.gt(pJoinT.<Integer>get("identificadorCliente"), identificadorCliente);

		cQuery.select(rootP).where(cb.and(pr1));

		final List<NttdataContrato> results = session.createQuery(cQuery).getResultList();

		return results;

	}

}
