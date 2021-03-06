package com.br.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.br.model.Pedido;

@Repository
public class PedidoDAO extends GenericDAO<Pedido>{



	@Override
	public Class<Pedido> getClassType() {
		return Pedido.class;
	}
	

	
	@SuppressWarnings("unchecked")
	public List<Pedido> procurarPorStatus(String status) {
		Query result = null;
		result = manager.createQuery("SELECT p FROM Pedido p WHERE p.status = :status ORDER BY p.id ASC").setParameter("status", status);
		return result.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> getById(Pedido filtro) {
		
		String str = "select c from Pedido c where c.id = :id";
		Query query=manager.createQuery(str);
		query.setParameter("id",filtro.getId());
		return query.getResultList();
	}



	public List<Pedido> buscarFiltro(Pedido filtro) {
		String str = "select p from Pedido p where 1 = 1";
		
		if(filtro.hasValidId()){
			str += " AND p.id = :id";
		}
		if(!filtro.getTipo().equals("Todos") && filtro.getTipo() != null){
			str += " AND p.tipo = :tipo";
		}
		if(!filtro.getStatus().equals("Todos") && filtro.getStatus() != null){
			str += " AND p.status = :status";
		}
		Query query=manager.createQuery(str);
		
		if(filtro.hasValidId()){
			query.setParameter("id", filtro.getId());
		}
		if(!filtro.getTipo().equals("Todos") && filtro.getTipo() != null){
			query.setParameter("tipo", filtro.getTipo());
		}
		if(!filtro.getStatus().equals("Todos") && filtro.getStatus() != null){
			query.setParameter("status", filtro.getStatus());
		}
		
		return query.getResultList();
	}

}
