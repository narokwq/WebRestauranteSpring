package com.br.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="Tradicional")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Tradicional extends Pedido {
	
	@ManyToOne
	private Mesa mesa;

	public Tradicional() {
	}
	public Tradicional(Long id) {
		setId(id);
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
}
