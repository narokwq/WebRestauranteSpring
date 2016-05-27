package com.br.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.model.Cliente;
import com.br.model.Funcionario;
import com.br.model.Usuario;
import com.br.services.UsuarioService;
import com.sun.security.ntlm.Client;



@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value={"/", "login"}, method=RequestMethod.GET)
	public String login(ModelMap map){
		Usuario usuario = new Usuario();
		map.addAttribute("usuario", usuario);
		return "login";
	}
	
	@RequestMapping(value="logar", method=RequestMethod.POST)
	public String logar(@ModelAttribute("usuario") Usuario user, HttpSession sessao, ModelMap map){
		if(user.getLogin() == null || user.getLogin().getSenha() == null ){
			map.addAttribute("usuario", user);
			return  "login";
		}
		
		Usuario usuarioBD = null;
		try {
			usuarioBD = usuarioService.logar(user.getLogin());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} 
		
		if(usuarioBD == null){
			user.getLogin().setSenha("");
			map.addAttribute("usuario", user);
			return  "login";
		}
		if(usuarioBD instanceof Cliente){
			sessao.setAttribute("home", "cliente");
		} else if (usuarioBD instanceof Funcionario) {
			sessao.setAttribute("home", "funcionario");
		} else {
			sessao.setAttribute("home", "gerente");
		}
		sessao.setAttribute("usuario", usuarioBD);
		return "redirect:/home";
	}
	
	
}
