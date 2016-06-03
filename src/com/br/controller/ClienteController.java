package com.br.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.model.Cliente;
import com.br.model.Login;
import com.br.services.ClienteService;

@RequestMapping(value = "cliente")
@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	// @RequestMapping(value="listar", method=RequestMethod.GET)
	// public String list(ModelMap map){
	//
	// List<Cliente> clientes = clienteService.listar();
	// map.addAttribute("clientes", clientes);
	// map.addAttribute("filtro", new Cliente());
	// map.addAttribute("categoriaItens");
	// return "listarcardapio";
	// }

	@RequestMapping(value = { "form" }, method = RequestMethod.GET)
	public String createForm(ModelMap map) {
		map.addAttribute("cliente", new Cliente());
		return "cadastrocliente";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/form/alter")
	public String updateForm(ModelMap map, HttpSession session) {
		Long id = (Long) session.getAttribute("id");
		Cliente cliente = clienteService.procurar(new Cliente(id));		
		session.setAttribute("login", cliente.getLogin());
		map.addAttribute("cliente", cliente);
		return "alterarcliente";
	}

	@RequestMapping(method = RequestMethod.GET, value = "remove")
	public String desativarCliente(ModelMap map, HttpSession session) throws Exception {
		Cliente cliente = (Cliente) session.getAttribute("usuario");
		clienteService.desativar(cliente);
		return "redirect:/login";
	}

	@RequestMapping(method = RequestMethod.POST, value = "save")
	public String save(@ModelAttribute("cliente") Cliente cliente, BindingResult result) throws Exception {

		if (!cliente.hasValidId()) {
			Date dataCadastro = new Date();
			cliente.getLogin().criarSenha(cliente.getLogin().getSenha());
			cliente.setDataCadastro(dataCadastro);
			clienteService.criar(cliente);
		}
		return "redirect:/login";
	}


	@RequestMapping(method = RequestMethod.POST, value = "update")
	public String update(@ModelAttribute("cliente") Cliente cliente,HttpSession session) throws Exception {
		Login login = (Login) session.getAttribute("login");
		cliente.setLogin(login);
		if (cliente.hasValidId())						
			clienteService.atualizar(cliente);
		return "redirect:/home";
	}

}
