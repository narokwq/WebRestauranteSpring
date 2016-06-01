package com.br.services;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dao.PedidoDAO;
import com.br.model.Pedido;
import com.br.model.Tradicional;

@Service
@Transactional
public class PedidoService {

	@Autowired
	PedidoDAO pedidoDAO;

	public List<Pedido> listar(){
		List<Pedido> result = Collections.emptyList();
		result = pedidoDAO.getAll();

		return result;
	}
}
