package com.br.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.br.model.Gerente;

@Repository
public class GerenteDAO extends GenericDAO<Gerente> {
	

	@Override
	public Class<Gerente> getClassType() {
		return Gerente.class;
	}
	
	public boolean exist(Gerente gerente){
		Query result = null;
		result = this.manager.createQuery("SELECT COUNT(c) FROM Gerente c WHERE c.login.login = :login");
		result.setParameter("login", gerente.getLogin().getLogin());
		
		return ((long) result.getSingleResult()) != 0;
	}

	public Gerente procurarPorLoginSenha(String login, String senha) {
		Query result = null;
		result = this.manager.createQuery("SELECT g FROM Gerente g WHERE g.login.login = :login and g.login.senha = :senha");
		result.setParameter("login", login);
		result.setParameter("senha", senha);
		return (Gerente) result.getSingleResult();
	}
}
