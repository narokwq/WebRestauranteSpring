package com.br.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dao.CargoDAO;
import com.br.model.Cargo;

@Service
@Transactional
public class CargoService {

	@Autowired
	CargoDAO cargoDAO;

	public void criar(Cargo cargo) {
		// EntityManager manager = JPAUtil.getEntityManager();
		cargoDAO.insert(cargo);

	}

	public void remover(Cargo cargo) {
		cargoDAO.delete(cargo);
	}

	public void atualizar(Cargo cargo) {
		cargoDAO.update(cargo);
	}

	public void desativar(Cargo cat) {
		Cargo cargo = procurar(cat);
		cargo.setDesativado(!cargo.isDesativado());
		atualizar(cargo);
	}

	public Cargo procurar(Cargo cargo) {
		Cargo result = null;
		result = cargoDAO.findById(cargo.getId());

		return result;
	}

	public List<Cargo> listar() {
		List<Cargo> result = Collections.emptyList();
		result = cargoDAO.getAll();
		Collections.sort(result);

		return result;
	}

	public List<Cargo> listarAtivo() {
		List<Cargo> result = Collections.emptyList();
		result = cargoDAO.getCargoAtivo();

		return result;
	}

	public List<Cargo> buscarFiltro(Cargo filtro) {
		List<Cargo> result = Collections.emptyList();
		result = cargoDAO.getByName(filtro);

		return result;
	}
}
