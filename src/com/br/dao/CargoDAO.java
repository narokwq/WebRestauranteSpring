package com.br.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.br.model.Cargo;

@Repository
public class CargoDAO extends GenericDAO<Cargo>{
	

	@Override
	public Class<Cargo> getClassType() {
		return Cargo.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cargo> getCargoAtivo(){
		String str = "select c from Cargo c where c.desativado = :ativo";
		Query query=manager.createQuery(str);
		query.setParameter("ativo", true);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Cargo> getByName(Cargo filtro) {
		String str = "select c from Cargo c where upper(c.descricao) like upper(:descricao)";
		Query query=manager.createQuery(str);
		query.setParameter("descricao", "%"+filtro.getDescricao()+"%");
		return query.getResultList();
	}
}
