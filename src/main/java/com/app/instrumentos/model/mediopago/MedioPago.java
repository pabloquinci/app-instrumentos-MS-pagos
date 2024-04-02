package com.app.instrumentos.model.mediopago;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name="medio_pago",schema="public_pagos")
@Inheritance(strategy = InheritanceType.JOINED)
public class MedioPago {
	@Id
	private Long medioPagoId;
}
