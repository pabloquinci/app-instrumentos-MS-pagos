package com.app.instrumentos.dto;

import java.util.ArrayList;
import java.util.List;

import com.app.instrumentos.model.Pago;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TarjetaDTO {
	private Long numTarjeta;
	private Long dniUsuario;
	public Long getNumTarjeta() {
		return numTarjeta;
	}
	public void setNumTarjeta(Long numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	public Long getDniUsuario() {
		return dniUsuario;
	}
	public void setDniUsuario(Long dniUsuario) {
		this.dniUsuario = dniUsuario;
	}
	
	
}
