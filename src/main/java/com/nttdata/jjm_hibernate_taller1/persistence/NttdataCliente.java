package com.nttdata.jjm_hibernate_taller1.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Formación - Hibernate - Taller1 y 2.
 * 
 * Entidad de la tabla cliente.
 * 
 * @author Javier Jiménez Montesino.
 *
 */
@Entity
@Table(name = "cliente")
public class NttdataCliente extends AbstractEntity implements Serializable {

	/**
	 * Versión
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * dni del cliente (Unique).
	 */
	String dni;

	/*
	 * Identificador del cliente (PK).
	 */
	Integer identificadorCliente;

	/*
	 * Nombre del cliente.
	 */
	String nombre;

	/*
	 * Primer apellido del cliente.
	 */
	String apellido;

	/*
	 * Segudno apellido del cliente.
	 */
	String apellido2;

	/*
	 * lista de contratos del cliente
	 */
	List<NttdataContrato> contratos = new ArrayList<>();

	/*
	 * Getters and Setters.
	 */

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cliente")
	public List<NttdataContrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<NttdataContrato> contratos) {
		this.contratos = contratos;
	}

	@Column(name = "DNI", nullable = false)
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getidentificadorCliente() {
		return identificadorCliente;
	}

	public void setidentificadorCliente(Integer identificador) {
		this.identificadorCliente = identificador;
	}

	@Column(name = "NOMBRE", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "PRIMER_APELLIDO", nullable = false)
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Column(name = "SEGUNDO_APELLIDO", nullable = false)
	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	@Override
	public String toString() {
		return "NttdataCliente [dni=" + dni + ", identificador=" + identificadorCliente + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", apellido2=" + apellido2 + "]";
	}

}
