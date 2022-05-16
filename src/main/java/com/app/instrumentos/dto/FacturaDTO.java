package com.app.instrumentos.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class FacturaDTO {
	private Long idDocumento;
	private BigDecimal numeroDocumento;
	private String tipo;
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
