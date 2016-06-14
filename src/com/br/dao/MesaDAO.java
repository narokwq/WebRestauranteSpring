package com.br.dao;

import java.util.List;

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
		String str = "select m from Mesa m where upper(m.descricao) like upper(:descricao) AND m.status is :status";
		if(filtro.getDescricao() == null){
			filtro.setDescricao("");
		}
		if(filtro.isPerReserva() != null){
			str+=" and m.perReserva is :perReserva";
		}
		Query query=manager.createQuery(str).setParameter("status", false);   
		
		query.setParameter("descricao", "%"+filtro.getDescricao()+"%");
		
		if(filtro.isPerReserva() != null){
			query.setParameter("perReserva", filtro.isPerReserva());
		}
		return query.getResultList();
	}

	public List<Mesa> getAllReserva() {
		String str = "select m from Mesa m where m.perReserva is :perReserva AND m.status is :status";
		Query query= manager.createQuery(str).setParameter("perReserva", true).setParameter("status", false);
		
		return query.getResultList();
	}

	public List<Mesa> buscarAtivo() {
		String str = "select m from Mesa m where m.status is :status";
		Query query= manager.createQuery(str).setParameter("status", false);
		return query.getResultList();
	}
	
}
