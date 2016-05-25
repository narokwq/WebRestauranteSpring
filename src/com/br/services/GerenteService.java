package com.br.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dao.GerenteDAO;
import com.br.model.Gerente;

@Service
@Transactional
public class GerenteService {

	@Autowired
	GerenteDAO gerenteDAO;
	
	public void criar(Gerente gerente) throws Exception {
//		EntityManager  manager =  JPAUtil.getEntityManager();
		boolean exist = gerenteDAO.exist(gerente);
		if(exist){
			throw new Exception("Usuario já existe");
		}			
		gerenteDAO.insert(gerente);
	}
	
	public void atualizar(Gerente gerente){
			gerenteDAO.update(gerente);
	}
	
	public  void remover(Gerente gerente){
			gerenteDAO.delete(gerente);
	}
	
	public  void desativar(Gerente gerente) {
		gerente.setDesativado(true);
		atualizar(gerente);
	}
	
	public   Gerente find(Gerente gerente) {
		Gerente result = null;
		result = gerenteDAO.findById(gerente.getId());	

		return result;
	}
	
	public  List<Gerente> listar(){
		List<Gerente> result = Collections.emptyList();
		result = gerenteDAO.getAll();

		return result;
	}

	public  Gerente procurarPorLoginSenha(String login, String senha) {
		Gerente result = null;		
		result = gerenteDAO.procurarPorLoginSenha(login,senha);	

		return result;
	}
}
