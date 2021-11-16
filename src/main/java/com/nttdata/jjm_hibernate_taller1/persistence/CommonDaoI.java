package com.nttdata.jjm_hibernate_taller1.persistence;

import java.util.List;

/**
 * Ejercicio - Hibernate - Taller 1 y 2.
 * 
 * DAO genérico interfaz.
 * 
 * @author Javier Jiménez Montesino.
 *
 */
public interface CommonDaoI<T> {

	/**
	 * Inserta un registro en la database.
	 * 
	 * @param paramT
	 */
	public void insert(final T paramT);

	/**
	 * Actualiza un registro en la database.
	 * 
	 * @param paramT
	 */
	public void update(final T paramT);

	/**
	 * Elimina un registro en la database.
	 * 
	 * @param paramT
	 */
	public void delete(final T paramT);

	/**
	 * Encuentra un registro por ID en la database.
	 * 
	 * @param paramT
	 */
	public T searchById(final Integer id);

	/**
	 * Buscador de todos los registros en la database.
	 * 
	 * @return List<T>
	 */
	public List<T> searchAll();

}
