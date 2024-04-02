package com.app.instrumentos.model.mediopago;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.app.instrumentos.model.Pago;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="tarjeta",schema="public_pagos")
public class Tarjeta extends MedioPago{
	
	@Column
	private Long numTarjeta;
	@Column
	private Long dniUsuario;
	@OneToMany(mappedBy="tarjeta", cascade=CascadeType.MERGE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Pago> pagos=new ArrayList<>();

	

}
