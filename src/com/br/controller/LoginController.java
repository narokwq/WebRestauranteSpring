package com.br.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.model.Cliente;
import com.br.model.Funcionario;
import com.br.model.Login;
import com.br.model.Usuario;
import com.br.services.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value={"/", "login"}, method=RequestMethod.GET)
	public String login(ModelMap map){
		map.addAttribute("login", new Login());
		return "login";
	}
	
	@RequestMapping(value="logar", method=RequestMethod.POST)
	public String logar(@Valid @ModelAttribute("login") Login user, BindingResult result, HttpSession sessao, ModelMap map){
		if(result.hasErrors()){
			return  "login";
		}
		
		Usuario usuarioBD = null;
		usuarioBD = usuarioService.logar(user);

		if(usuarioBD == null){
			user.setSenha("");
			result.rejectValue("","login", "Nome de usuário ou senha errados. Por favor tente outra vez.");
			return  "login";
		}
//		Temporario, mudar pra tabela de permissões no futuro
		if(usuarioBD instanceof Cliente){
			sessao.setAttribute("home", "cliente");
		} else if (usuarioBD instanceof Funcionario) {
			sessao.setAttribute("home", "funcionario");
		} else {
			sessao.setAttribute("home", "gerente");
		}
//		Fim
		sessao.setAttribute("usuario", usuarioBD);
		return "redirect:/home";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String login(HttpSession session){
		session.invalidate();
		return "redirect:/login";
	}
	

}
