package com.br.dao;

import java.util.List;

import javax.persistence.EntityManager;
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
		return (List<Pedido>) result.getResultList();
	}
	

}
