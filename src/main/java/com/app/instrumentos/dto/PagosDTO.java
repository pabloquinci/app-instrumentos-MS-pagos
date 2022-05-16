package com.app.instrumentos.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PagosDTO {
	public List<PagoDTO> getPagos() {
		return pagos;
	}

	public void setPagos(List<PagoDTO> pagos) {
		this.pagos = pagos;
	}

	private List<PagoDTO> pagos=new ArrayList<>();

}
