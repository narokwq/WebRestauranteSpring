package com.br.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.br.model.Reserva;

@Repository
public class ReservaDAO extends GenericDAO<Reserva>{



	@Override
	public Class<Reserva> getClassType() {
		return Reserva.class;
	}
	
	public boolean checkSave(Reserva reserva) {
		String str = "select r from Reserva r where (:dataI BETWEEN r.dataInicio AND r.dataFim) OR (:dataF BETWEEN r.dataInicio AND r.dataFim) OR ((r.dataInicio BETWEEN :dataI AND :dataF) AND ((r.dataFim BETWEEN :dataI AND :dataF)))";
		Query query=manager.createQuery(str);
		query.setParameter("dataI", reserva.getDataInicio());
		query.setParameter("dataF", reserva.getDataFim());
		
		List<Reserva> reservas = query.getResultList();
		return reservas.isEmpty() ? true:false;
		
	}

	public List<Reserva> buscar(Reserva filtro) {
		String str = "select r from Reserva r where upper(r.nomeResp) like upper(:resp)";
		
		if(filtro.getMesa().hasValidId()){
			str+= " and r.mesa.id = :mesaId";
		}
		if(filtro.getDataInicio() != null && filtro.getDataFim() != null){
			str+= " and (r.dataInicio BETWEEN :dataI AND :dataF) AND (r.dataFim BETWEEN :dataI AND :dataF)";
		}else if(filtro.getDataInicio() != null){
			str+= " and (r.dataInicio = :dataI)";
		}else if(filtro.getDataFim() != null){
			str+= " and (r.dataFim = :dataF)";
		}
		Query query=manager.createQuery(str); 
		
		query.setParameter("resp", "%"+filtro.getNomeResp() == null ? "":"%"+filtro.getNomeResp()+"%");
		
		if(filtro.getMesa().hasValidId()){
			query.setParameter("mesaId", filtro.getMesa().getId());
		}

		if(filtro.getDataInicio() != null){
			query.setParameter("dataI", filtro.getDataInicio());
		}
		if(filtro.getDataFim() != null){
			query.setParameter("dataF", filtro.getDataFim());
		}
		
		return query.getResultList();
	}
}
