package com.br.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dao.DeliveryDAO;
import com.br.dao.PedidoDAO;
import com.br.dao.TradicionalDAO;
import com.br.model.Pedido;

@Service
@Transactional
public class PedidoService {

	@Autowired
	PedidoDAO pedidoDAO;

	@Autowired
	DeliveryDAO deliveryDAO;

	@Autowired
	TradicionalDAO tradicionalDAO;

	public Pedido procurar(Pedido pedido) {
		return pedidoDAO.findById(pedido.getId());
	}

	public List<Pedido> listar() {
		List<Pedido> result = Collections.emptyList();
		result = pedidoDAO.getAll();

		return result;
	}


	public List<Pedido> buscarFiltro(Pedido filtro) {
		List<Pedido> result = Collections.emptyList();
		result = pedidoDAO.buscarFiltro(filtro);
		
		return result;
	}

	public void atualizar(Pedido pedido) {
		pedidoDAO.update(pedido);
		
	}
}
