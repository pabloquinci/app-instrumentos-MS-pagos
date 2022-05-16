package com.app.instrumentos.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="factura",schema="public_pagos")
public class Factura {
	@Id
	private Long idDocumento;
	@Column
	private BigDecimal numeroDocumento;
	@Column
	private String tipo;
	@Column
	private BigDecimal monto;
	public Long getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(Long idDocumento) {
		this.idDocumento = idDocumento;
	}
	public BigDecimal getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(BigDecimal numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	

}
