package com.br.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.br.model.Reserva;

@Repository
public class ReservaDAO extends GenericDAO<Reserva>{



	@Override
	public Class<Reserva> getClassType() {
		return Reserva.class;
	}
}
