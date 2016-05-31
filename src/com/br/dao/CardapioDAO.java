package com.br.dao;



import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.br.model.Cardapio;

@Repository
public class CardapioDAO extends GenericDAO<Cardapio>{
	
	@Override
	public Class<Cardapio> getClassType() {
		return Cardapio.class;
	}
	
	public Object procurarPorNome(String nome){
		Query query = manager.createQuery("select c from Cardapio c where c.nome = :nome").setParameter("nome",nome);
		return query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Cardapio> buscar(Cardapio filtro){
		String str = "select c from Cardapio c where upper(nome) like upper(:nome)";
		Long id = filtro.getCategoria().getId();
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
		if(id != null && id != 0){
			str+=" and c.categoria.id = :categoria";
		}
		Query query=manager.createQuery(str);   
		
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		
		if(id != null && id != 0){
			query.setParameter("categoria", filtro.getCategoria().getId());
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Cardapio> getAllAtivo() {
		String str = "select c from Cardapio c where c.status = :status";
		Query query=manager.createQuery(str);   
		
		query.setParameter("status", true);
		
		return query.getResultList();
	}

}
