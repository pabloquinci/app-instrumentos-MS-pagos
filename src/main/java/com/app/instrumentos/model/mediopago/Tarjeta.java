package com.app.instrumentos.model.mediopago;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.app.instrumentos.model.Pago;

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
