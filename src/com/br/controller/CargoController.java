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

import com.br.model.Cargo;
import com.br.services.CargoService;


@RequestMapping(value="cargo")
@Controller
public class CargoController {
	
	@Autowired
	private CargoService cargoService;
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map){
		
		List<Cargo> cargos = cargoService.listar();
		map.addAttribute("cargos", cargos);
		map.addAttribute("filtro", new Cargo());
		return "listarcargo";
	}
	
	@RequestMapping(value={"form"}, method=RequestMethod.GET)
	public String cadastro(ModelMap map){
		map.addAttribute("statusDesativado");
		map.addAttribute("cargo", new Cargo());
		return "cadastrocargo";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/form")
	public String updateForm(@PathVariable Long id, ModelMap map){
		cargoService.desativar(new Cargo(id));
		return "redirect:/cargo/listar";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("cargo") Cargo cargo){
		cargoService.criar(cargo);	
		return "redirect:/cargo/listar";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Cargo filtro, ModelMap map){
		
		List<Cargo> cargos = cargoService.buscarFiltro(filtro);
		map.addAttribute("cargos", cargos);
		map.addAttribute("filtro", filtro);
		return "listarcargo";
	}
	
	@ModelAttribute(value="statusDesativado")
	public Map<Boolean, String > selectStatus(ModelMap map){
		
		Map<Boolean, String> status = new HashMap<>();  
		status.put(true, "Ativo"); 
		status.put(false, "Desativado"); 	 		 
		return status;
	}

}
