package com.br.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Cargo")
public class Cargo implements EntityClass, Comparable<Cargo>{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private boolean desativado;
	
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return "Cargo [descrição=" + descricao + "]";
	}

	public boolean isDesativado() {
		return desativado;
	}

	public void setDesativado(boolean desativado) {
		this.desativado = desativado;
	}
	@Override
	public int compareTo(Cargo o) {
//		return status ? -1:1;
		return this.id > o.getId() ? 1 : -1;
	}
}
