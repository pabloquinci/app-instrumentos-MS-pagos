package com.app.instrumentos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.instrumentos.exception.MercadoPagoException;

@RestControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(UsernameNotFoundException.class)
	protected ResponseEntity<String> userNotFound(UsernameNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MercadoPagoException.class)
	protected ResponseEntity<String> paymentError(MercadoPagoException ex){
		return new ResponseEntity<String>("MP Error: " + ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<String> paymentError(Exception ex){
		return new ResponseEntity<String>("Error en pago", HttpStatus.NOT_FOUND);
	}
	

}
