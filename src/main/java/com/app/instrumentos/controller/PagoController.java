package com.app.instrumentos.controller;

import java.util.List;

import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.instrumentos.dto.FacturaDTO;
import com.app.instrumentos.dto.NotificationsRequestDTO;
import com.app.instrumentos.dto.PagoDTO;
import com.app.instrumentos.dto.PagosDTO;
import com.app.instrumentos.dto.TarjetaDTO;
import com.app.instrumentos.dto.mp.CardPaymentDTO;
import com.app.instrumentos.dto.mp.PaymentResponseDTO;
import com.app.instrumentos.model.Pago;
import com.app.instrumentos.repository.PagoRepository;
import com.app.instrumentos.service.MercadoPagoService;
import com.app.instrumentos.utils.Utils;

import jakarta.validation.Valid;

@RestController
public class PagoController {
	
	@Autowired PagoRepository pagoRepository;
	@Autowired MercadoPagoService mercadoPagoService;
	
	@Value("${secret-notifications}")
	private String secret;
	
	@PostMapping("/process_payment")
	 public ResponseEntity<PaymentResponseDTO> processPayment(@RequestBody @Valid CardPaymentDTO cardPaymentDTO) {
        PaymentResponseDTO payment = mercadoPagoService.processPayment(cardPaymentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
	
	@PostMapping("/notifications")
	 public ResponseEntity<?> notification(@RequestBody @Valid NotificationsRequestDTO request, @RequestHeader("v1") String v1) {
		String secret=v1;
		String cyphedSignature = new HmacUtils("HmacSHA256",secret).hmacHex(secret);

       return ResponseEntity.ok("Ok clave");
   }
	
	@GetMapping("/getpagos")
	private PagosDTO getPagos(@RequestParam(name="idUsuario")Long idUsuario){
		List<Pago> pagos= pagoRepository.findAll();
		PagosDTO pagosDTO=new PagosDTO();
		Utils.armarDTORespuesta(pagos,pagosDTO);
		return pagosDTO;
	}

}
