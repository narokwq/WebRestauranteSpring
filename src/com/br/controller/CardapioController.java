package com.br.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.model.Cardapio;
import com.br.model.Categoria;
import com.br.services.CardapioService;
import com.br.services.CategoriaService;


@RequestMapping(value="cardapio")
@Controller
public class CardapioController {
	
	@Autowired
	private CardapioService cardapioService;
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map){
		
		List<Cardapio> cardapios = cardapioService.listar();
		map.addAttribute("cardapios", cardapios);
		map.addAttribute("filtro", new Cardapio());
		map.addAttribute("categoriaItens");
		return "listarcardapio";
	}
	
	@RequestMapping(value={"form"}, method=RequestMethod.GET)
	public String createForm(ModelMap map){
		map.addAttribute("categoriaItens", selectCategoriaAtivado());
		map.addAttribute("cardapio", new Cardapio());
		return "cadastrocardapio";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/form")
	public String updateForm(@PathVariable Long id, ModelMap map){
		Cardapio cardapio = cardapioService.procurar(new Cardapio(id));
		Map<Long, String> categorias = selectCategoriaAtivado();
		categorias.put(cardapio.getCategoria().getId(), cardapio.getCategoria().getNome());
		map.addAttribute("categoriaItens",categorias);
		map.addAttribute("cardapio", cardapio);
		return "cadastrocardapio";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/remove")
	public String desativarCardapio(@PathVariable Long id, ModelMap map) throws Exception{
		cardapioService.desativar(new Cardapio(id));
		return "redirect:/cardapio/listar";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@Valid @ModelAttribute("cardapio") Cardapio cardapio, BindingResult result) throws Exception{
		if(result.hasErrors()){
			return "cadastrocardapio";
		}
		if(cardapio.hasValidId()){
			cardapioService.atualizar(cardapio);
		}
		else{
			cardapioService.criar(cardapio);
		}	
		return "redirect:/cardapio/listar";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Cardapio filtro, ModelMap map){
		
		List<Cardapio> cardapios = cardapioService.buscarFiltro(filtro);
		map.addAttribute("cardapios", cardapios);
		map.addAttribute("filtro", filtro);
		map.addAttribute("categoriaItens");
		return "listarcardapio";
	}
	
	public Map<Long, String > selectCategoriaAtivado(){
		
		Map<Long, String> categorias = new HashMap<>(); 

		for (Categoria categoria : categoriaService.listarAtivo()) {
			categorias.put(categoria.getId(), categoria.getNome());
		}	 		 
		return categorias;
	}
	
	@ModelAttribute(value="categoriaItens")
	public Map<Long, String > selectCategoriaAll(){
		
		Map<Long, String> categorias = new HashMap<>(); 

		for (Categoria categoria : categoriaService.listar()) {
			categorias.put(categoria.getId(), categoria.getNome());
		}
		
		System.out.println(categorias);
	 		 
		return categorias;
	}

}
