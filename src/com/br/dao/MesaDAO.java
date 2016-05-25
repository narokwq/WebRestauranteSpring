package com.br.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.br.model.Mesa;

@Repository
public class MesaDAO extends GenericDAO<Mesa>{


	@Override
	public Class<Mesa> getClassType() {
		return Mesa.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Mesa> buscarFiltro(Mesa filtro){
		String str = "select m from Mesa m where upper(m.descricao) like upper(:descricao)";
		if(filtro.getDescricao() == null){
			filtro.setDescricao("");
		}
		if(filtro.isPerReserva() != null){
			str+=" and m.perReserva is :perReserva";
		}
		Query query=manager.createQuery(str);   
		
		query.setParameter("descricao", "%"+filtro.getDescricao()+"%");
		
		if(filtro.isPerReserva() != null){
			query.setParameter("perReserva", filtro.isPerReserva());
		}
		return query.getResultList();
	}
}
