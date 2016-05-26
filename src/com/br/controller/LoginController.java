package com.br.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.model.Login;
import com.br.model.Usuario;
import com.br.services.UsuarioService;



//@RequestMapping(value="login")
@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value={"/", "login"}, method=RequestMethod.GET)
	public String list(ModelMap map){
		map.addAttribute("user", new Login());
			
		return "login/index";
	}
	
	@RequestMapping(value="logar", method=RequestMethod.POST)
	public String logar(@ModelAttribute("usuario") Login user, HttpSession sessao, ModelMap map){
		if(user.getLogin() == null || user.getSenha() == null ){
			map.addAttribute("user", user);
			return  "/login/index";
		}
		
		Usuario usuarioBD = null;
		try {
			usuarioBD = usuarioService.logar(user);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} 
		
		if(usuarioBD == null){
			user.setSenha("");
			map.addAttribute("user", user);
			return  "/login/index";
		}
		sessao.setAttribute("user", user);
		return "redirect:/cardapio/listar";
	}
	
	
}
