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
import com.br.model.Cliente;
import com.br.model.Delivery;
import com.br.model.ItemCardapio;
import com.br.model.ParamItem;
import com.br.model.Usuario;
import com.br.services.CardapioService;
import com.br.services.DeliveryService;

@RequestMapping(value = "delivery")
@Controller
public class DeliveryController {

	@Autowired
	private CardapioService cardapioService;
	@Autowired
	private DeliveryService deliveryService;

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public String list(ModelMap map, HttpSession session) {

		List<Delivery> deliverys = deliveryService.procurarPorClienteId((Usuario) session.getAttribute("usuario"));
		Collections.sort(deliverys);
		map.addAttribute("deliverys", deliverys);
		map.addAttribute("filtro", new Delivery());

		return "listardelivery";
	}

	@RequestMapping(value = "{id}/detalhado", method = RequestMethod.GET)
	public String detalhar(@PathVariable Long id, ModelMap map, HttpSession session) {

		Delivery delivery = deliveryService.procurar(new Delivery(id));

		map.addAttribute("delivery", delivery);

		return "detalhardeliverycliente";
	}

	@RequestMapping(value = "filtrar", method = RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Delivery filtro, ModelMap map, HttpSession session) {
		filtro.setCliente((Cliente) session.getAttribute("usuario"));
		List<Delivery> deliverys = deliveryService.buscarFiltro(filtro);
		Collections.sort(deliverys);
		map.addAttribute("deliverys", deliverys);
		map.addAttribute("filtro", filtro);
		return "listardelivery";
	}

	@RequestMapping(value = { "form" }, method = RequestMethod.GET)
	public String createForm(ModelMap map, HttpSession session) {
		Delivery delivery = getItensSession(session);
		map.addAttribute("itemCardapio", new ParamItem());
		map.addAttribute("delivery", delivery);
		map.addAttribute("cardapioItens");
		return "cadastrodelivery";
	}

	@RequestMapping(value = "adiciona", method = RequestMethod.POST)
	public String adicionarItem(@ModelAttribute("itemCardapio") ParamItem param, HttpSession session) {
		Cardapio cardapio = cardapioService.procurar(new Cardapio(param.getId()));
		ItemCardapio item = new ItemCardapio();
		item.setCardapio(cardapio);
		item.setQtd(param.getQtd());
		addItem(session, item);
		return "redirect:/delivery/form";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/remove")
	public String desativarCardapio(@PathVariable Long id, ModelMap map, HttpSession session) throws Exception {
		Delivery delivery = getItensSession(session);
		List<ItemCardapio> lista = delivery.getItensCardapio();

		for (int x = 0; x < lista.size(); x++) {
			if (lista.get(x).getCardapio().getId() == id) {
				lista.remove(x);
			}
		}

		setItensSession(session, delivery);
		return "redirect:/delivery/form";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/cancelar")
	public String cancelarDelivery(@PathVariable Long id, ModelMap map) throws Exception {
		Delivery delivery = deliveryService.procurar(new Delivery(id));
		if (delivery.getStatus().equals("Pendente")) {
			delivery.setStatus("Cancelado");
			deliveryService.atualizar(delivery);
		}
		return "redirect:/delivery/listar";
	}

	@RequestMapping(method = RequestMethod.POST, value = "save")
	public String save(@RequestParam("pagamento") Float troco, HttpSession session) throws Exception {

		Delivery delivery = getItensSession(session);
		if (troco < delivery.getTotal()) {
			return "redirect:/delivery/form";
		}
		if (!delivery.getItensCardapio().isEmpty()) {
			delivery.setCliente((Cliente) session.getAttribute("usuario"));
			delivery.setTroco(troco - delivery.getTotal());
			deliveryService.criar(delivery);
			setItensSession(session, new Delivery());
		}
		return "redirect:/delivery/listar";
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

	// Manipulando Delivery na Sessao

	private void addItem(HttpSession session, ItemCardapio item) {
		Delivery delivery = getItensSession(session);
		boolean exist = false;
		for (ItemCardapio atual : delivery.getItensCardapio()) {
			if (atual.getCardapio().getId() == item.getCardapio().getId()) {
				atual.setQtd(atual.getQtd() + item.getQtd());
				exist = true;
			}
		}
		if (!exist)
			delivery.addItemCardapio(item);
		setItensSession(session, delivery);
	}

	private Delivery getItensSession(HttpSession session) {
		Delivery delivery = (Delivery) session.getAttribute("delivery");
		if (delivery == null) {
			delivery = new Delivery();
			setItensSession(session, delivery);
		}
		return delivery;
	}

	private void setItensSession(HttpSession session, Delivery delivery) {
		session.setAttribute("delivery", delivery);
	}
}
