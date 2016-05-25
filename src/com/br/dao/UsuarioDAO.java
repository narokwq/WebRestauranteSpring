package com.br.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.br.model.Login;
import com.br.model.Usuario;

@Repository
public class UsuarioDAO extends GenericDAO<Usuario>{


	public Class<Usuario> getClassType() {
		return Usuario.class;
	}
	
	public boolean exist(Usuario usuario){
		Query result = null;
		result = this.manager.createQuery("SELECT COUNT(c) FROM Usuario c WHERE c.login.login = :login");
		result.setParameter("login", usuario.getLogin().getLogin());
		
		return ((long) result.getSingleResult()) != 0;
	}
	
	public Usuario procurarLoginSenha(Login login){
			Query query = manager.createQuery("SELECT u FROM Usuario u WHERE u.login.login = :login and u.login.senha = :senha and u.desativado = :status ");
			query.setParameter("login",login.getLogin());
			query.setParameter("senha",login.getSenha());
			query.setParameter("status", false);
		
			List<Usuario> usuarios =  query.getResultList();
			
			return usuarios.isEmpty() ? null : usuarios.get(0);
	}
}
