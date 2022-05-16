package com.app.instrumentos.utils;

import java.util.List;

import com.app.instrumentos.dto.FacturaDTO;
import com.app.instrumentos.dto.PagoDTO;
import com.app.instrumentos.dto.PagosDTO;
import com.app.instrumentos.dto.TarjetaDTO;
import com.app.instrumentos.model.Pago;

public class Utils {
	
	public static void armarDTORespuesta(List<Pago> pagos, PagosDTO pagosDTO) {
		pagos.stream().forEach(p->{
			PagoDTO pagoDTO=new PagoDTO();
			FacturaDTO facturaDTO=new FacturaDTO();
			facturaDTO.setIdDocumento(p.getFactura().getIdDocumento());
			facturaDTO.setMonto(p.getFactura().getMonto());
			facturaDTO.setNumeroDocumento(p.getFactura().getNumeroDocumento());
			facturaDTO.setTipo(p.getFactura().getTipo());
			
			TarjetaDTO tarjetaDTO=new TarjetaDTO();
			
			pagoDTO.setFactura(facturaDTO);
			pagoDTO.setFechaPago(p.getFechaPago());
			pagoDTO.setIdPago(p.getIdPago());
			pagoDTO.setIdUsuario(p.getIdUsuario());
			pagoDTO.setMonto(p.getMonto());
			pagoDTO.setFactura(facturaDTO);
			
			pagosDTO.getPagos().add(pagoDTO);
		});
	}

}
