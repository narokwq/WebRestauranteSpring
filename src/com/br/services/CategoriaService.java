package com.br.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.dao.CategoriaDAO;
import com.br.model.Categoria;

@Service
@Transactional
public class CategoriaService {

	@Autowired
	CategoriaDAO categoriaDAO;

	public void criar(Categoria categoria) {
		// EntityManager manager = JPAUtil.getEntityManager();
		categoriaDAO.insert(categoria);

	}

	public void remover(Categoria categoria) {
		categoriaDAO.delete(categoria);
	}

	public void atualizar(Categoria categoria) {
		categoriaDAO.update(categoria);
	}

	public void desativar(Categoria cat) {
		Categoria categoria = procurar(cat);
		categoria.setStatus(!categoria.isStatus());
		atualizar(categoria);
	}

	public Categoria procurar(Categoria categoria) {
		Categoria result = null;
		result = categoriaDAO.findById(categoria.getId());

		return result;
	}

	public List<Categoria> listar() {
		List<Categoria> result = Collections.emptyList();
		result = categoriaDAO.getAll();
		Collections.sort(result);

		return result;
	}

	public List<Categoria> listarAtivo() {
		List<Categoria> result = Collections.emptyList();
		result = categoriaDAO.getCategoriaAtivo();

		return result;
	}

	public List<Categoria> buscarFiltro(Categoria filtro) {
		List<Categoria> result = Collections.emptyList();
		result = categoriaDAO.getByName(filtro);

		return result;
	}
}
