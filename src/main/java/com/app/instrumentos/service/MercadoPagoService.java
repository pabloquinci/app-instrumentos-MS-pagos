package com.app.instrumentos.service;

import com.app.instrumentos.dto.OrderEvent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.app.instrumentos.dto.mp.CardPaymentDTO;
import com.app.instrumentos.dto.mp.PaymentResponseDTO;
import com.app.instrumentos.exception.MercadoPagoException;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
@Service
public class MercadoPagoService{

	@Value("${mercado_pago_sample_access_token}")
	private String mercadoPagoAccessToken;
	
	private ModelMapper modelMapper;

	@Autowired
	private ProducerService orderProducer;



	public PaymentResponseDTO processPayment(CardPaymentDTO cardPaymentDTO) {
		OrderEvent event = new OrderEvent();

		try {
	    MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);

	  	PaymentClient paymentClient = new PaymentClient();
	
	    PaymentCreateRequest paymentCreateRequest =
	        PaymentCreateRequest.builder()
	            .transactionAmount(cardPaymentDTO.getTransactionAmount())
	            .token(cardPaymentDTO.getToken())
	            .description(cardPaymentDTO.getProductDescription())
	            .installments(cardPaymentDTO.getInstallments())
	            .paymentMethodId(cardPaymentDTO.getPaymentMethodId())
	            .payer(
	                PaymentPayerRequest.builder()
	                    .email(cardPaymentDTO.getPayer().getEmail())
	                    .identification(
	                        IdentificationRequest.builder()
	                            .type(cardPaymentDTO.getPayer().getIdentification().getType())
	                            .number(cardPaymentDTO.getPayer().getIdentification().getNumber())
	                            .build())
	                    .build())
	            .build();
	
	    Payment createdPayment = paymentClient.create(paymentCreateRequest);
	    
	    PaymentResponseDTO paymentRespDTO= modelMapper.map(createdPayment,PaymentResponseDTO.class);
	    
	    return paymentRespDTO;
	
	    /*return new PaymentResponseDTO(
	        createdPayment.getId(),
	        String.valueOf(createdPayment.getStatus()),
	        createdPayment.getStatusDetail());*/
	  } catch (MPApiException apiException) {
			event.setStatus("ERROR 2");
			event.setMessage("El pago no se produjo");
			orderProducer.sendMessage(event);
			System.out.println(apiException.getApiResponse().getContent());
	    	throw new MercadoPagoException(apiException.getApiResponse().getContent());


	  } catch (MPException exception) {
			event.setStatus("El pago no se produjo");
			event.setMessage("Order is in pending status");
			orderProducer.sendMessage(event);
	    	System.out.println(exception.getMessage());
	    	throw new MercadoPagoException(exception.getMessage());
	  }
	}

}
