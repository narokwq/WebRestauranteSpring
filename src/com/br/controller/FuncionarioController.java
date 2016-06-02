package com.br.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.model.Funcionario;
import com.br.services.FuncionarioService;

@RequestMapping(value = "funcionario")
@Controller
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

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
		map.addAttribute("funcionario", new Funcionario());
		return "cadastrofuncionario";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/form")
	public String updateForm(@PathVariable Long id, ModelMap map, HttpSession session) {
		Funcionario funcionario = new Funcionario();
		funcionario.setId(id);
		funcionario = funcionarioService.procurar(funcionario);
		map.addAttribute("funcionario", funcionario);
		return "alterarfuncionario";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/remove")
	public String desativar(@PathVariable Long id, ModelMap map) throws Exception {
		funcionarioService.desativar(new Funcionario(id));
		return "redirect:funcionariolistar";
	}

	@RequestMapping(method = RequestMethod.POST, value = "save")
	public String save(@ModelAttribute("funcionario") Funcionario funcionario, BindingResult result) throws Exception {

		if (!funcionario.hasValidId()) {
			funcionario.getLogin().criarSenha(funcionario.getLogin().getSenha());
			funcionarioService.criar(funcionario);
		}
		return "redirect:/login";
	}

	@RequestMapping(method = RequestMethod.POST, value = "update")
	public String update(@ModelAttribute("funcionario") Funcionario funcionario) throws Exception {
		if (funcionario.hasValidId())
			funcionarioService.atualizar(funcionario);
		return "redirect:/home";
	}

}
