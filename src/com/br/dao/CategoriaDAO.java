package com.br.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.br.model.Categoria;

@Repository
public class CategoriaDAO extends GenericDAO<Categoria>{
	

	@Override
	public Class<Categoria> getClassType() {
		return Categoria.class;
	}
	
	public List<Categoria> getCategoriaAtivo(){
		String str = "select c from Categoria c where c.status = :ativo";
		Query query=manager.createQuery(str);
		query.setParameter("ativo", true);
		return query.getResultList();
	}

	public List<Categoria> getByName(Categoria filtro) {
		String str = "select c from Categoria c where upper(c.nome) like upper(:nome)";
		Query query=manager.createQuery(str);
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		return query.getResultList();
	}
}
