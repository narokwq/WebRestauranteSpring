package com.br.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Size;

@Entity(name = "Funcionario")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Funcionario extends Usuario implements Comparable<Usuario> {

	@Column(nullable = false)
	private float salario;
	@Column(nullable = false, length = 11)
	@Size(min=11 ,max = 11, message = "Cpf invalido!")
	private String cpf;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;

	public Funcionario() {

	}

	public Funcionario(Long id) {
		this.setId(id);
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int compareTo(Usuario o) {
		return getNome().compareTo(o.getNome());
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public boolean hasValidId() {
		return getId() != null && getId() != 0;
	}
}
