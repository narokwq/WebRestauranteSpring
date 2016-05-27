package com.br.services;

import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dao.UsuarioDAO;
import com.br.model.Login;
import com.br.model.Usuario;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	UsuarioDAO usuarioDAO;
	
		public  void criar(Usuario usuario) throws Exception {
//			EntityManager  manager =  JPAUtil.getEntityManager();
			boolean exist = usuarioDAO.exist(usuario);
			if(exist){
				throw new Exception("Usuario já existe");
			}					
			usuarioDAO.insert(usuario);
		}
		
		public void atualizar(Usuario usuario){
			usuarioDAO.update(usuario);
		}
		
		public void remover(Usuario usuario){
			usuarioDAO.delete(usuario);
		}
		
		public void desativar(Usuario usuario) {
			usuario.setDesativado(true);
			atualizar(usuario);
		}
		
		public Usuario procurar(Usuario usuario) {
			Usuario result = null;
			result = usuarioDAO.findById(usuario.getId());

			return result;
		}
		
		public Usuario procurarPorLoginSenha(Login login) {
			Usuario result = null;
			result = usuarioDAO.procurarLoginSenha(login);
			
			return result;
		}
		
		public  List<Usuario> listar(){
			List<Usuario> result = Collections.emptyList();
			result = usuarioDAO.getAll();

			return result;
		}

		public Usuario logar(Login login){
			try {
				login.criarSenha(login.getSenha());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			return procurarPorLoginSenha(login);
		}
	

}
