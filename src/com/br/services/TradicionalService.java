package com.br.services;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dao.ItemCardapioDAO;
import com.br.dao.TradicionalDAO;
import com.br.model.ItemCardapio;
import com.br.model.Tradicional;

@Service
@Transactional
public class TradicionalService {

	@Autowired
	TradicionalDAO pedidoDAO;
	@Autowired
	ItemCardapioDAO ItemCardapioDAO;

	public void criar(Tradicional pedido) throws Exception {
		//		EntityManager  manager =  JPAUtil.getEntityManager();
		for(ItemCardapio itemCardapio:pedido.getItensCardapio()){
			if(itemCardapio.getCardapio() == null ){
				throw new Exception("Item sem cardápio");
			}
			ItemCardapioDAO.insert(itemCardapio);
		}
		if(pedido.getFuncionario() == null || pedido.getMesa() == null){
			throw new Exception("Pedido não tem Funcionario ou Mesa");
		}		
		pedidoDAO.insert(pedido);
	}

	public void atualizar(Tradicional pedido) throws Exception {			
		for(ItemCardapio itemCardapio:pedido.getItensCardapio()){
			if(itemCardapio.getCardapio() == null ){
				throw new Exception("Item sem cardápio");
			}
			ItemCardapioDAO.update(itemCardapio);
		}
		pedidoDAO.update(pedido);
	}

	public void remover(Tradicional pedido) {
		pedido.setStatus("Cancelado");
		pedidoDAO.update(pedido);
	}

	public Tradicional procurar(Tradicional pedido) {
		Tradicional result = null;
		result = pedidoDAO.findById(pedido.getId());

		return result;
	}

	public List<Tradicional> listar(){
		List<Tradicional> result = Collections.emptyList();
		result = pedidoDAO.getAll();

		return result;
	}

	public List<Object[]> relatorioPorIntervaloData(Date dataI,Date dataF){
		List<Object[]> lista = null;
		lista = pedidoDAO.getRelatorioPorData(dataI, dataF);				

		return lista;
	}

	public  List<Tradicional> procurarPorStatus(String status) {
		List<Tradicional> result = null;	
		result = pedidoDAO.procurarPorStatus(status);

		return result;
	}

}
