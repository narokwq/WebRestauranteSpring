package com.br.controller;

import java.text.NumberFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.br.model.Cardapio;
import com.br.model.Funcionario;
import com.br.model.ItemCardapio;
import com.br.model.Mesa;
import com.br.model.Tradicional;
import com.br.services.CardapioService;
import com.br.services.MesaService;
import com.br.services.TradicionalService;

@RequestMapping(value = "tradicional")
@Controller
public class TradicionalController {

	@Autowired
	private CardapioService cardapioService;
	@Autowired
	private TradicionalService tradicionalService;
	@Autowired
	private MesaService mesaService;

	@RequestMapping(value = "{id}/detalhado", method = RequestMethod.GET)
	public String detalhar(@PathVariable Long id, ModelMap map, HttpSession session) {

		Tradicional tradicional = tradicionalService.procurar(new Tradicional(id));

		map.addAttribute("tradicional", tradicional);

		return "detalhartradicionalcliente";
	}

	@RequestMapping(value = { "form" }, method = RequestMethod.GET)
	public String createForm(ModelMap map, HttpSession session) {
		Tradicional tradicional = getItensSession(session);
		map.addAttribute("itemCardapio", new ItemCardapio());
		map.addAttribute("tradicional", tradicional);
		map.addAttribute("cardapioItens");
		map.addAttribute("mesaOpcao");
		return "cadastrotradicional";
	}

	@RequestMapping(value = "adiciona", method = RequestMethod.POST)
	public String adicionarItem(@ModelAttribute("itemCardapio") ItemCardapio item, HttpSession session) {
		Cardapio cardapio = cardapioService.procurar(new Cardapio(item.getCardapio().getId()));
		item.setCardapio(cardapio);
		addItem(session, item);
		return "redirect:/tradicional/form";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/remove")
	public String desativarCardapio(@PathVariable Long id, ModelMap map, HttpSession session) throws Exception {
		Tradicional tradicional = getItensSession(session);
		List<ItemCardapio> lista = tradicional.getItensCardapio();

		for (int x = 0; x < lista.size(); x++) {
			if (lista.get(x).getCardapio().getId() == id) {
				lista.remove(x);
			}
		}

		setItensSession(session, tradicional);
		return "redirect:/tradicional/form";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/cancelar")
	public String cancelarTradicional(@PathVariable Long id, ModelMap map) throws Exception {
		Tradicional tradicional = tradicionalService.procurar(new Tradicional(id));
		if (tradicional.getStatus().equals("Pendente")) {
			tradicional.setStatus("Cancelado");
			tradicionalService.atualizar(tradicional);
		}
		return "redirect:/pedido/listar";
	}

	@RequestMapping(method = RequestMethod.GET, value = "save")
	public String save(@ModelAttribute("tradicional") Tradicional trad, HttpSession session) throws Exception {
		Mesa newmesa = mesaService.procurar(trad.getMesa());
		Tradicional tradicional = getItensSession(session);
		if (!tradicional.getItensCardapio().isEmpty()) {
			tradicional.setMesa(newmesa);
			tradicional.setFuncionario((Funcionario) session.getAttribute("usuario"));
			tradicional.setStatus(trad.getStatus());
			tradicional.setTipo("Tradicional");
			tradicionalService.criar(tradicional);
			setItensSession(session, new Tradicional());
		}
		return "redirect:/pedido/listar";
	}

	@ModelAttribute(value = "cardapioItens")
	public Map<Long, String> selectCategoriaAtivado() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		Map<Long, String> cardapios = new HashMap<>();
		for (Cardapio cardapio : cardapioService.listarAtivo()) {
			cardapios.put(cardapio.getId(), cardapio.getNome() + " - " + formatter.format(cardapio.getPreco()));
		}
		return cardapios;
	}
	
	@ModelAttribute(value="mesaOpcao")
	public Map<Long, String > selectStatus(){
		Map<Long, String> status = new HashMap<>();  
		List<Mesa> mesas = mesaService.listar();
		if(mesas != null)
			for(Mesa mesa :mesas){
				status.put(mesa.getId(), mesa.getDescricao());
			}	 		 
		return status;
	}
	// Manipulando Tradicional na Sessao

	private void addItem(HttpSession session, ItemCardapio item) {
		Tradicional tradicional = getItensSession(session);
		boolean exist = false;
		for (ItemCardapio atual : tradicional.getItensCardapio()) {
			if (atual.getCardapio().getId() == item.getCardapio().getId()) {
				atual.setQtd(atual.getQtd() + item.getQtd());
				exist = true;
			}
		}
		if (!exist)
			tradicional.addItemCardapio(item);
		setItensSession(session, tradicional);
	}

	private Tradicional getItensSession(HttpSession session) {
		Tradicional tradicional = (Tradicional) session.getAttribute("tradicional");
		if (tradicional == null) {
			tradicional = new Tradicional();
			setItensSession(session, tradicional);
		}
		return tradicional;
	}

	private void setItensSession(HttpSession session, Tradicional tradicional) {
		session.setAttribute("tradicional", tradicional);
	}
}
