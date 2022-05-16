package com.app.instrumentos.model.mediopago;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
@Entity
@Table(name="medio_pago",schema="public_pagos")
@Inheritance(strategy = InheritanceType.JOINED)
public class MedioPago {
	@Id
	private Long medioPagoId;
}
