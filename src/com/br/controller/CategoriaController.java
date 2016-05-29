package com.br.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.model.Categoria;
import com.br.services.CategoriaService;


@RequestMapping(value="categoria")
@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value={"form"}, method=RequestMethod.GET)
	public String login(ModelMap map){

		Map<String, String> status = new HashMap<String,String>();  
		status.put("true", "Ativo");  
		status.put("false", "Desativado");
		map.addAttribute("statusItens", status);
		map.addAttribute("categoria", new Categoria());
		return "cadastrocategoria";
	}
	
//	@ModelAttribute(value="selectStatus")
//	public Map<Boolean, String > selectStatus(ModelMap map){
//		
//		Map<Boolean, String> status = new HashMap<>();  
//		status.put(true, "Ativo");  
//		status.put(false, "Desativado");  
//		return status;
//	}

}
