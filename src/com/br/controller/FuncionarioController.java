package com.br.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.model.Cargo;
import com.br.model.Funcionario;
import com.br.model.Mesa;
import com.br.services.CargoService;
import com.br.services.FuncionarioService;

@RequestMapping(value = "funcionario")
@Controller
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private CargoService cargoService;

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public String list(ModelMap map, HttpSession session) {

		List<Funcionario> funcionarios = funcionarioService.listar();
		session.setAttribute("funcionarios", funcionarios);
		map.addAttribute("filtro", new Funcionario());
		// map.addAttribute("categoriaItens");
		return "listarfuncionario";
	}

	@RequestMapping(value = { "form" }, method = RequestMethod.GET)
	public String createForm(ModelMap map) {
		map.addAttribute("funcionario", new Funcionario());
		map.addAttribute("cargos");
		return "cadastrofuncionario";
	}
	
	@RequestMapping(value = "filtrar", method = RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Funcionario filtro, ModelMap map) {

		List<Funcionario> funcionarios = funcionarioService.buscarFiltro(filtro);
		map.addAttribute("funcionarios", funcionarios);
		map.addAttribute("filtro", filtro);
		return "listarfuncionario";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{id}/form")
	public String updateForm(@PathVariable Long id, ModelMap map) {	
		Funcionario funcionario = funcionarioService.procurar(new Funcionario(id));
		map.addAttribute("funcionario", funcionario);
		map.addAttribute("cargos");
		return "alterarfuncionario";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/remove")
	public String desativar(@PathVariable Long id, ModelMap map) throws Exception {
		funcionarioService.desativar(new Funcionario(id));
		return "redirect:funcionariolistar";
	}

	@RequestMapping(method = RequestMethod.POST, value = "save")
	public String save(@Valid @ModelAttribute("funcionario") Funcionario funcionario, BindingResult result)
			throws Exception {
		if (result.hasErrors()) {
			return "cadastrofuncionario";
		}
		if (!funcionario.hasValidId()) {
			funcionario.getLogin().criarSenha(funcionario.getLogin().getSenha());
			funcionarioService.criar(funcionario);
		}
		return "redirect:/home";
	}

	@RequestMapping(method = RequestMethod.POST, value = "update")
	public String update(@Valid @ModelAttribute("funcionario") Funcionario funcionario, BindingResult result)	throws Exception {		
		if (funcionario.hasValidId())
			funcionarioService.atualizar(funcionario);
		return "redirect:/funcionario/listar";
	}

	@ModelAttribute(value = "cargos")
	public Map<Long, String> selectCategoriaAtivado() {
		Map<Long, String> cargos = new HashMap<>();
		for (Cargo cargo : cargoService.listarAtivo()) {
			cargos.put(cargo.getId(), cargo.getDescricao());
		}
		return cargos;
	}

}
