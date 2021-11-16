package com.nttdata.jjm_hibernate_taller1.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

/**
 * Ejercicio - Hibernate - Taller 1 y 2.
 * 
 * DAO genérico Implementación.
 * 
 * @author Javier Jiménez Montesino.
 *
 */
public class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/** Almacena el tipo de clase */
	private Class<T> entityClass;

	/** Almacena la Sesión de conexión */
	private Session session;

	/**
	 * Método constructor.
	 * 
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session) {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	/*
	 * Método insert sobreescrito de CommonDaoI
	 */
	@Override
	public void insert(final T paramT) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.save(paramT);
		session.flush();

		// Commit.
		session.getTransaction().commit();
	}

	/*
	 * Método update sobreescrito de CommonDaoI
	 */
	@Override
	public void update(final T paramT) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.saveOrUpdate(paramT);

		// Commit.
		session.getTransaction().commit();
	}

	/*
	 * Método update sobreescrito de CommonDaoI
	 */
	@Override
	public void delete(final T paramT) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.delete(paramT);

		// Commit.
		session.getTransaction().commit();
	}

	/*
	 * Método searchById sobreescrito de CommonDaoI
	 */
	@Override
	public T searchById(final Integer id) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda por PK.
		T result = session.get(this.entityClass, id);

		return result;

	}

	/*
	 * Método searchAll sobreescrito de CommonDaoI
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda de todos los registros.
		List<T> list = session.createQuery("FROM " + this.entityClass.getName()).list();

		return list;

	}

	/**
	 * Método que consigue la clase desde la cual se ha invocado.
	 * 
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * Método que establece el tipo de clase.
	 * 
	 * @param entityClass the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
