package com.br.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dao.FuncionarioDAO;
import com.br.model.Funcionario;

@Service
@Transactional
public class FuncionarioService {

	@Autowired
	FuncionarioDAO funcionarioDAO;
	
	public void criar(Funcionario funcionario) throws Exception {
//		EntityManager  manager =  JPAUtil.getEntityManager();

		boolean exist = funcionarioDAO.exist(funcionario);
		if(exist){
			throw new Exception("Funcionario já existe");
		}
				
		funcionarioDAO.insert(funcionario);
	}
	
	public void atualizar(Funcionario funcionario){
			funcionarioDAO.update(funcionario);
	}
	
	public void remover(Funcionario funcionario){
			funcionarioDAO.delete(funcionario);
	}
	
	public void desativar(Funcionario funcionario) {
		funcionario.setDesativado(true);
		atualizar(funcionario);
	}
	
	public   Funcionario procurar(Funcionario funcionario) {
		Funcionario result = null;
		result = funcionarioDAO.findById(funcionario.getId());

		return result;
	}
	
	public  List<Funcionario> listar(){
		List<Funcionario> result = Collections.emptyList();
		result = funcionarioDAO.getAll();

		return result;
	}

	public  List<Funcionario> buscarFiltro(Funcionario filtro) {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		funcionarios = funcionarioDAO.buscar(filtro);

		return funcionarios;
	}

	
}
