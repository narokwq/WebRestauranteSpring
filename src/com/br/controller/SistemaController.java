package com.br.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class SistemaController {
	
//	@Autowired
//	private UsuarioService usuarioService;
	
	@RequestMapping(value="home", method=RequestMethod.GET)
	public String login(ModelMap map){
		return "home";
	}
	
}
