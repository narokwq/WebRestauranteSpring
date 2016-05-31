package com.br.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.model.Mesa;
import com.br.services.MesaService;

@RequestMapping(value = "mesa")
@Controller
public class MesaController {

	@Autowired
	private MesaService mesaService;

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public String list(ModelMap map) {

		List<Mesa> mesas = mesaService.listar();
		map.addAttribute("mesas", mesas);
		map.addAttribute("filtro", new Mesa());
		// map.addAttribute("categoriaItens");
		return "listarmesa";
	}

	@RequestMapping(value = { "form" }, method = RequestMethod.GET)
	public String createForm(ModelMap map) {
		// map.addAttribute("categoriaItens", selectCategoriaAtivado());
		map.addAttribute("mesa", new Mesa());
		return "cadastromesa";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/form")
	public String updateForm(@PathVariable Long id, ModelMap map) {
		Mesa mesa = mesaService.procurar(new Mesa(id));
		Map<Long,String> mesas = selectMesaLista();
		mesas.put(mesa.getId(), mesa.getDescricao());
		map.addAttribute("mesa", mesa);
		return "cadastromesa";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/remove")
	public String desativarCardapio(@PathVariable Long id, ModelMap map) throws Exception {
		mesaService.remover(new Mesa(id));
		return "redirect:/mesa/listar";
	}

	@RequestMapping(method = RequestMethod.POST, value = "save")
	public String save(@ModelAttribute("mesa") Mesa mesa, BindingResult result) throws Exception {
		if (mesa.hasValidId()) {
			mesaService.atualizar(mesa);
		} else {
			mesaService.criar(mesa);
		}
		return "redirect:/mesa/listar";
	}

	@RequestMapping(value = "filtrar", method = RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Mesa filtro, ModelMap map) {

		List<Mesa> mesas = mesaService.buscarFiltro(filtro);
		map.addAttribute("mesas", mesas);
		map.addAttribute("filtro", filtro);
		// map.addAttribute("categoriaItens");
		return "/mesa/listar";
	}

	public Map<Long, String> selectMesaLista() {

		Map<Long, String> mesas = new HashMap<>();

		for (Mesa mesa : mesaService.listar()) {
			mesas.put(mesa.getId(), mesa.getDescricao());
		}
		return mesas;
	}
	// public Map<Long, String> selectMesaAtivado() {
	//
	// Map<Long, String> categorias = new HashMap<>();
	//
	// for (Mesa mesa : mesaService.listarAtivo()) {
	// categorias.put(mesa.getId(), mesa.getNome());
	// }
	//
	// return categorias;
	// }

	// @ModelAttribute(value = "categoriaItens")
	// public Map<Long, String> selectCategoriaAll() {
	//
	// Map<Long, String> categorias = new HashMap<>();
	//
	// for (Categoria categoria : categoriaService.listar()) {
	// categorias.put(categoria.getId(), categoria.getNome());
	// }
	//
	// System.out.println(categorias);
	//
	// return categorias;
	// }

}
