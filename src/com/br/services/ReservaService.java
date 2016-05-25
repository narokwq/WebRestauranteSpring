package com.br.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dao.ReservaDAO;
import com.br.model.Reserva;

@Service
@Transactional
public class ReservaService {

	@Autowired
	ReservaDAO reservaDAO;
	
	public void criar(Reserva reserva) throws Exception {
//		EntityManager  manager =  JPAUtil.getEntityManager();
		if(reserva.getMesa() == null || reserva.getFuncionario() == null){
			throw new Exception("Reserva sem mesa ou funcionario responsavel");
		}
			
		reservaDAO.insert(reserva);
	}
	
	public void atualizar(Reserva reserva) throws Exception {
		if(reserva.getMesa() == null || reserva.getFuncionario() == null){
			throw new Exception("Reserva sem mesa ou funcionario responsavel");
		}
		reservaDAO.update(reserva);
	}
	
	public void remover(Reserva reserva) {			
			reservaDAO.delete(reserva);
	}
	
	public   Reserva procurar(Reserva reserva) {
		Reserva result = null;			
		result = reservaDAO.findById(reserva.getId());

		return result;
	}
	
	public  List<Reserva> listar(){
		List<Reserva> result = Collections.emptyList();
		result = reservaDAO.getAll();

		return result;
	}
}
