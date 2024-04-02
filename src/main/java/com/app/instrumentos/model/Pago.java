package com.app.instrumentos.model;

import java.math.BigDecimal;
import java.util.Date;


import com.app.instrumentos.model.mediopago.Tarjeta;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="pago",schema="public_pagos")
public class Pago {
	
	@Id
	private Long idPago;
	@Column
	private Date fechaPago;
	@Column
	private Long idUsuario;
	@Column
	private BigDecimal monto;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="medio_pago_id",nullable=true)	
	private Tarjeta tarjeta;
	@ManyToOne(cascade=CascadeType.MERGE)
	private Factura factura;
	public Long getIdPago() {
		return idPago;
	}
	public void setIdPago(Long idPago) {
		this.idPago = idPago;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	

}
