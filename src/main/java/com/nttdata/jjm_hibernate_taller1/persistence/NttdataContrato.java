package com.nttdata.jjm_hibernate_taller1.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Formación - Hibernate - Taller 1 y 2
 * 
 * Entidad de la tabla Contrato
 * 
 * @author Javier Jiménez Montesino
 *
 */
@Entity
@Table(name = "contrato")
public class NttdataContrato extends AbstractEntity implements Serializable {

	/**
	 * Versión
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Identificador del contrato (PK).
	 */
	Integer identificadorContrato;

	/*
	 * Fecha de vigencia del contrato.
	 */
	Date fechaVigencia;

	/*
	 * Fecha de caducidad del contrato.
	 */
	Date fechaCaducidad;

	/*
	 * Precio a pagar mensualmente.
	 */
	Integer precioMensual;

	/*
	 * Cliente al que pertenece el contrato(FK).
	 */
	NttdataCliente cliente;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getidentificadorContrato() {
		return identificadorContrato;
	}

	public void setIdentificadorContrato(Integer identificador) {
		this.identificadorContrato = identificador;
	}

	@Column(name = "FECHA_VIGENCIA", nullable = false)
	public Date getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	@Column(name = "FECHA_CADUCIDAD", nullable = false)
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	@Column(name = "PRECIO_MENSUAL", nullable = false)
	public Integer getPrecioMensual() {
		return precioMensual;
	}

	public void setPrecioMensual(Integer precioMensual) {
		this.precioMensual = precioMensual;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "identificador")
	public NttdataCliente getCliente() {
		return cliente;
	}

	public void setCliente(NttdataCliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "NttdataContrato [identificador=" + identificadorContrato + ", fechaVigencia=" + fechaVigencia
				+ ", fechaCaducidad=" + fechaCaducidad + ", precioMensual=" + precioMensual + ", cliente=" + cliente
				+ "]";
	}

}
