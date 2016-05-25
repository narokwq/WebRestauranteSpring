package com.br.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dao.CardapioDAO;
import com.br.model.Cardapio;

@Service
@Transactional
public class CardapioService {
	
	@Autowired
	private CardapioDAO cardapioDAO;

	public void criar(Cardapio cardapio) throws Exception {
		if(cardapio.getCategoria() == null){
			throw new Exception("Cardapio sem categoria");
		}
	
		cardapioDAO.insert(cardapio);
	}
	
	public void atualizar(Cardapio cardapio) throws Exception {
		if(cardapio.getCategoria() == null){
			throw new Exception("Cardapio sem categoria");
		}
	
		cardapioDAO.update(cardapio);

	}
	
	public void remover(Cardapio cardapio){
		cardapioDAO.delete(cardapio);
	}
	
	public Cardapio procurar(Cardapio cardapio) {
		Cardapio result = null;
		result = cardapioDAO.findById(cardapio.getId());

		return result;
	}
	
	public Cardapio procurarPorNome(String nome) {
		Cardapio result = null;
		result = (Cardapio)cardapioDAO.procurarPorNome(nome);

		return result;
	}
	
	public List<Cardapio> listar(){
		List<Cardapio> result = Collections.emptyList();
		result = cardapioDAO.getAll();

		return result;
	}
	
	public List<Cardapio> listarAtivo(){
		List<Cardapio> result = Collections.emptyList();
		result = cardapioDAO.getAllAtivo();

		return result;
	}
	
	
	public void desativar(Cardapio car) throws Exception {
		Cardapio cardapio = procurar(car);
		cardapio.setStatus(!cardapio.isStatus());
		atualizar(cardapio);
	}
	
	public List<Cardapio> buscarFiltro(Cardapio filtro){
		List<Cardapio> cardapios = new ArrayList<Cardapio>();
		cardapios = cardapioDAO.buscar(filtro);
	
		return cardapios;
	}



}
