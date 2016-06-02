package com.br.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "Funcionario")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Funcionario extends Usuario implements DeliveryListener, Comparable<Usuario> {

	@Column(nullable = false)
	private float salario;
	@Column(nullable = false, length = 11)
	private String cpf;

	@ManyToOne
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;

	@OneToMany(mappedBy="user", cascade={CascadeType.ALL, CascadeType.REMOVE})
	private List<Notificacao> notificacoes;
	
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

	@Override
	public void pedidoCancelado() {
		Notificacao notificacao = new Notificacao();
		notificacao.setMensage("Um pedido delivery foi cancelado");
		notificacao.setUser(this);
		this.notificacoes.add(notificacao);
	}

	@Override
	public void pedidoStatusModificado(String status) {
		// TODO Auto-generated method stub
		
	}
}
