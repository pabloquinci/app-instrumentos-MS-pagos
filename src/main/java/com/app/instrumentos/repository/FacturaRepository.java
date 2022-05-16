package com.app.instrumentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.instrumentos.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

}
