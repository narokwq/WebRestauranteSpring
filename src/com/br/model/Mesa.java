package com.br.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="Mesa")
public class Mesa implements EntityClass{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int numero;
	@NotEmpty(message="Preencha descricao")
	private String descricao;
	@Min(value=2, message="Minimo 2 lugares")
	private int capacidade;
	private Boolean perReserva;
	private boolean status;
	
	

	public Mesa() {
		
	}
	
	public Mesa(Long id) {
		this.id = id;
	}
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public Boolean isPerReserva() {
		return perReserva;
	}
	public void setPerReserva(Boolean perReserva) {
		this.perReserva = perReserva;
	}
	

	public Boolean getPerReserva() {
		return perReserva;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean hasValidId(){
		return getId() != null && getId() != 0;
	}
	

}
