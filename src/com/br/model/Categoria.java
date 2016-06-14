package com.br.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Categoria")
public class Categoria implements EntityClass, Comparable<Categoria>{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
		
	private String nome;
	private boolean status;
	
	public Categoria() {}
	public Categoria(Long id) {
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public int compareTo(Categoria o) {
//		return status ? -1:1;
		return this.id > o.getId() ? 1 : -1;
	}

	
}
