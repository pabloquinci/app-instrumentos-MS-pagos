package com.app.instrumentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.instrumentos.model.Pago;

public interface PagoRepository extends JpaRepository <Pago, Long> {

}
