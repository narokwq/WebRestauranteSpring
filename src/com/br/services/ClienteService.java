package com.br.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dao.ClienteDAO;
import com.br.model.Cliente;
import com.br.model.Login;

@Service
@Transactional
public class ClienteService {

	@Autowired
	ClienteDAO clienteDAO;
	
	public void criar(Cliente cliente) throws Exception {
//		EntityManager  manager =  JPAUtil.getEntityManager();
		boolean exist = clienteDAO.exist(cliente);
		if(exist){
			throw new Exception("Usuario já existe");
		}
				
		clienteDAO.insert(cliente);
	}
	
	public void atualizar(Cliente cliente){
		clienteDAO.update(cliente);
	}
	
	public void remover(Cliente cliente) throws Exception{
		if(cliente.getDeliverys() == null){
			throw new Exception("Usuario possui deliveres registrado");
		}
		clienteDAO.delete(cliente);

	}
	
	public void desativar(Cliente cliente) {
		cliente.setDesativado(true);
		atualizar(cliente);
	}
	
	
	public Cliente procurar(Cliente cliente) {
		Cliente result = null;
		result = clienteDAO.findById(cliente.getId());
		
		return result;
	}
	
	public Cliente procurarPorLoginSenha(Login login) {
		Cliente result = null;
		result = clienteDAO.procurarLoginSenha(login);

		return result;
	}
	
	public List<Cliente> listar(){
		List<Cliente> result = Collections.emptyList();
		result = clienteDAO.getAll();
		
		return result;
	}
	
	public  List<Cliente> buscarFiltro(Cliente filtro) {
		List<Cliente> cliente = new ArrayList<Cliente>();
		cliente = clienteDAO.buscar(filtro);

		return cliente;
	}
}
