package com.app.instrumentos.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.instrumentos.dto.FacturaDTO;
import com.app.instrumentos.dto.PagoDTO;
import com.app.instrumentos.dto.PagosDTO;
import com.app.instrumentos.dto.TarjetaDTO;
import com.app.instrumentos.model.Pago;
import com.app.instrumentos.repository.PagoRepository;
import com.app.instrumentos.utils.Utils;

@RestController
public class PagoController {
	
	@Autowired PagoRepository pagoRepository;
	
	@PostMapping("/process_payment")
	private ResponseEntity<?>processPayment(HttpServletRequest request ){

		return null;
	}
	
	@GetMapping("/getpagos")
	private PagosDTO getPagos(@RequestParam(name="idUsuario")Long idUsuario){
		List<Pago> pagos= pagoRepository.findAll();
		PagosDTO pagosDTO=new PagosDTO();
		Utils.armarDTORespuesta(pagos,pagosDTO);
		return pagosDTO;
	}

}
