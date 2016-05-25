package com.br.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.br.model.ItemCardapio;

@Repository
public class ItemCardapioDAO extends GenericDAO<ItemCardapio>{
	


	@Override
	public Class<ItemCardapio> getClassType() {
		return ItemCardapio.class;
	}

}
