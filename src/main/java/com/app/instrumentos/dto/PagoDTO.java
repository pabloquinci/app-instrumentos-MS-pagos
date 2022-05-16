package com.app.instrumentos.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PagoDTO {
	private Long idPago;
	private Date fechaPago;
	private Long idUsuario;
	private BigDecimal monto;
	private TarjetaDTO tarjeta;
	private FacturaDTO factura;
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
	public TarjetaDTO getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(TarjetaDTO tarjeta) {
		this.tarjeta = tarjeta;
	}
	public FacturaDTO getFactura() {
		return factura;
	}
	public void setFactura(FacturaDTO factura) {
		this.factura = factura;
	}
}

