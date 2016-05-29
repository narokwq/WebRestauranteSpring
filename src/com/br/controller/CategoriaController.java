package com.br.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.model.Categoria;
import com.br.services.CategoriaService;


@RequestMapping(value="categoria")
@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map){
		
		List<Categoria> categorias = categoriaService.listar();
		map.addAttribute("categorias", categorias);
		map.addAttribute("filtro", new Categoria());
		return "listarcategoria";
	}
	
	@RequestMapping(value={"form"}, method=RequestMethod.GET)
	public String login(ModelMap map){
		map.addAttribute("statusItens");
		map.addAttribute("categoria", new Categoria());
		return "cadastrocategoria";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/form")
	public String updateForm(@PathVariable Long id, ModelMap map){
		categoriaService.desativar(new Categoria(id));
		return "redirect:/categoria/listar";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("categoria") Categoria categoria){
		categoriaService.criar(categoria);	
		return "redirect:/categoria/listar";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Categoria filtro, ModelMap map){
		
		List<Categoria> categorias = categoriaService.buscarFiltro(filtro);
		map.addAttribute("categorias", categorias);
		map.addAttribute("filtro", filtro);
		return "listarcategoria";
	}
	
	@ModelAttribute(value="statusItens")
	public Map<Boolean, String > selectStatus(ModelMap map){
		
		Map<Boolean, String> status = new HashMap<>();  
		status.put(true, "Ativo"); 
		status.put(false, "Desativado"); 	 		 
		return status;
	}

}
