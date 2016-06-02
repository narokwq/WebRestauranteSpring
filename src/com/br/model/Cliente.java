package com.br.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "Cliente")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Cliente extends Usuario{

	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dataNasc;

	@Embedded
	private Endereco endereco;

	@OneToMany(mappedBy = "cliente")
	private Collection<Delivery> deliverys;

	@OneToMany(mappedBy="user", cascade={CascadeType.ALL, CascadeType.REMOVE})
	private List<Notificacao> notificacoes;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(Long id) {
		this.setId(id);
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String toString() {
		return String.format("Nome: %s\nCliente desde: %s\nData de Nascimento: %s\n\t -- Endere�o --\n %s", getNome(),
				this.dataCadastro, this.dataNasc, this.endereco);
	}

	public Collection<Delivery> getDeliverys() {
		return deliverys;
	}

	public void setDeliverys(Collection<Delivery> deliverys) {
		this.deliverys = deliverys;
	}

	public int compareTo(Usuario user) {
		int valor = 0;
		if (user instanceof Cliente) {
			Cliente cli = ((Cliente) user);
			valor = getDataCadastro().compareTo(cli.getDataCadastro());
		}
		return valor;
	}
	public boolean hasValidId(){
		return getId() != null && getId() != 0;
	}

	@Override
	public void pedidoCancelado() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pedidoStatusModificado(String status) {
		Notificacao notificacao = new Notificacao();
		notificacao.setMensage("Um pedido mudou o status para "+ status);
		notificacao.setUser(this);
		this.notificacoes.add(notificacao);
		
		System.out.println("Um pedido mudou o status para "+ status);
		
	}

}
