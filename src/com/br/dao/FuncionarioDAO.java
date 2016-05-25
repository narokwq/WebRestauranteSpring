package com.br.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.br.model.Cardapio;
import com.br.model.Funcionario;

@Repository
public class FuncionarioDAO extends GenericDAO<Funcionario>{


	@Override
	public Class<Funcionario> getClassType() {
		return Funcionario.class;
	}
	
	public boolean exist(Funcionario funcionario){
		Query result = null;
		result = this.manager.createQuery("SELECT COUNT(c) FROM Funcionario c WHERE c.login.login = :login");
		result.setParameter("login", funcionario.getLogin().getLogin());
		
		return ((long) result.getSingleResult()) != 0;
	}

	public List<Funcionario> buscar(Funcionario filtro) {

			String str = "select f from Funcionario f where upper(nome) like upper(:nome)";
			if(filtro.getNome() == null){
				filtro.setNome("");
			}
			Query query=manager.createQuery(str);   
			
			query.setParameter("nome", "%"+filtro.getNome()+"%");
			
			return query.getResultList();	
	}

	
}
