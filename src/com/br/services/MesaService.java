package com.br.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dao.MesaDAO;
import com.br.model.Mesa;

@Service
@Transactional
public class MesaService {

	@Autowired
	MesaDAO mesaDAO;
	
	public void criar(Mesa mesa) {
		mesaDAO.insert(mesa);
	}
	
	public void atualizar(Mesa mesa) {
		mesaDAO.update(mesa);
	}
	
	public void remover(Mesa mesa) {
		mesaDAO.delete(mesa);
	}
	
	public   Mesa procurar(Mesa mesa) {
		Mesa result = null;
		result = mesaDAO.findById(mesa.getId());

		return result;
	}
	
	public  List<Mesa> listar(){
		List<Mesa> result = Collections.emptyList();
		result = mesaDAO.getAll();

		return result;
	}
	
	public  List<Mesa> buscarFiltro(Mesa filtro){
		List<Mesa> mesas = new ArrayList<Mesa>();
		mesas = mesaDAO.buscarFiltro(filtro);

		return mesas;
	}
	
}
