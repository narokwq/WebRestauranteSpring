package com.br.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

@Entity(name="Delivery")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Delivery extends Pedido{
	
	@Transient
	List<DeliveryListener> listener = new ArrayList<>();
	
	private float troco;
	
	public Delivery() {
	}
	
	public Delivery(Long id) {
		this.setId(id);
	}

	@ManyToOne
	private Cliente cliente;
	
	public float getTroco() {
		return troco;
	}

	public void setTroco(float troco) {
		this.troco = troco;
	}
	public String toString(){
		return String.format("Troco: %f", this.troco);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Collection<DeliveryListener> getListener() {
		return listener;
	}

	public void setListener(List<DeliveryListener> listener) {
		this.listener = listener;
	}
	
	public void addListener(DeliveryListener listener) {
		this.listener.add(listener);
	}
	
	public void mudouEstado(){
		for (DeliveryListener deliveryListener : listener) {
			deliveryListener.pedidoStatusModificado(getStatus());
		}
	}
	
	public void setStatus(String status) {
		this.setStatus(status);
		mudouEstado();
	}
	
}
