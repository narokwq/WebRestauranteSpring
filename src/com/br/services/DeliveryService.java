package com.br.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dao.DeliveryDAO;
import com.br.dao.ItemCardapioDAO;
import com.br.model.Delivery;
import com.br.model.ItemCardapio;

@Service
@Transactional
public class DeliveryService {

	@Autowired
	DeliveryDAO deliveryDAO;
	@Autowired
	ItemCardapioDAO ItemCardapioDAO;
	
	public void criar(Delivery delivery) throws Exception {
//		EntityManager  manager =  JPAUtil.getEntityManager();
		if(delivery.getCliente() == null ){
			throw new Exception("Delivery sem cliente");
		}			
		deliveryDAO.insert(delivery);	// Primeiro tinha que inserir o delivery para o itemCardapio setar o id do pedido
			
		for(ItemCardapio itemCardapio:delivery.getItensCardapio()){
			if(itemCardapio.getCardapio() == null ){
				throw new Exception("Item sem cardápio");
			}
			itemCardapio.setPedido(delivery);
			ItemCardapioDAO.insert(itemCardapio);
		}
	}
	
	public void atualizar(Delivery delivery) throws Exception {			
		for(ItemCardapio itemCardapio:delivery.getItensCardapio()){
			if(itemCardapio.getCardapio() == null ){
				throw new Exception("Item sem cardápio");
			}
			ItemCardapioDAO.update(itemCardapio);
		}
		deliveryDAO.update(delivery);
	}
	
	public void remover(Delivery delivery) {
			for(ItemCardapio ItemCardapio:delivery.getItensCardapio()){
				ItemCardapioDAO.delete(ItemCardapio);
			}			
			deliveryDAO.delete(delivery);
	}
	
	public void desativar(Long id) {
			deliveryDAO.desativar(id);
	}
	
	public Delivery procurar(Delivery delivery) {
		Delivery result = null;
		result = deliveryDAO.findById(delivery.getId());

		return result;
	}
	
	public List<Delivery> procurarPorClienteId(Long id) {
		List<Delivery> result = null;
		result = deliveryDAO.procurarPorClienteId(id);

		return result;
	}

	public List<Delivery> procurarPorStatus(Long id, String status) {
		List<Delivery> result = null;
		result = deliveryDAO.procurarPorStatus(id,status);
	
		return result;
	}
	
	public List<Delivery> procurarPorStatus(String status) {
		List<Delivery> result = null;
		result = deliveryDAO.procurarPorStatus(status);

		return result;
	}
	
	public List<Delivery> listar(){
		List<Delivery> result = Collections.emptyList();
		result = deliveryDAO.getAll();

		return result;
	}
	
	public List<Object[]> relatorioPorIntervaloData(Date dataI,Date dataF){
		List<Object[]> lista = null;
		lista = deliveryDAO.getRelatorioPorData(dataI, dataF);			

		return lista;
	}
	
	public List<Delivery> buscarFiltro(Delivery filtro){
		List<Delivery> mesas = new ArrayList<Delivery>();
		mesas = deliveryDAO.buscarFiltro(filtro);

		return mesas;
	}

}
