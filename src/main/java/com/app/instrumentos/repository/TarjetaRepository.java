package com.app.instrumentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.instrumentos.model.mediopago.Tarjeta;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Long>{

}
