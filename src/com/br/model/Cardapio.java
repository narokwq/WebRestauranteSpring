package com.br.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "Cardapio")
public class Cardapio implements EntityClass {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotEmpty(message = "Nome n�o pode ser vazio.")
	private String nome;
	private float preco;
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	public Cardapio() {

	}

	public Cardapio(Long id) {
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

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean hasValidId() {
		return getId() != null && getId() != 0;
	}

	@Override
	public String toString() {
		return "Cardapio [nome=" + nome + ", preco=" + preco + "]";
	}

}
