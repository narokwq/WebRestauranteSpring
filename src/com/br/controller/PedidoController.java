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
import com.br.model.Pedido;
import com.br.services.PedidoService;


@RequestMapping(value="pedido")
@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;

	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map, HttpSession session){
		
		List<Pedido> pedido = pedidoService.listar();
		Collections.sort(pedido);
		map.addAttribute("pedidos", pedido);
		map.addAttribute("filtro", new Pedido());
		
		return "listarpedidos";
	}
	
/*	@RequestMapping(value="{id}/detalhado", method=RequestMethod.GET)
	public String detalhar(@PathVariable Long id, ModelMap map, HttpSession session){
		
		Delivery delivery = deliveryService.procurar(new Delivery(id));
		
		map.addAttribute("delivery", delivery);
		
		return "detalhardeliverycliente";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Delivery filtro, ModelMap map, HttpSession session){
		filtro.setCliente((Cliente)session.getAttribute("usuario"));
		List<Delivery> deliverys = deliveryService.buscarFiltro(filtro);
		Collections.sort(deliverys);
		map.addAttribute("deliverys", deliverys);
		map.addAttribute("filtro", filtro);
		return "listardelivery";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/cancelar")
	public String cancelarDelivery(@PathVariable Long id, ModelMap map) throws Exception{
		Delivery delivery = deliveryService.procurar(new Delivery(id));
		if(delivery.getStatus().equals("Pendente")){
			delivery.setStatus("Cancelado");
			deliveryService.atualizar(delivery);
		}
		return "redirect:/delivery/listar";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@RequestParam("pagamento") Float troco, HttpSession session) throws Exception{
		
		Delivery delivery = getItensSession(session);
		if(troco < delivery.getTotal()){
			return "redirect:/delivery/form";
		}
		if(!delivery.getItensCardapio().isEmpty()){
			delivery.setCliente((Cliente)session.getAttribute("usuario"));
			delivery.setTroco(troco-delivery.getTotal());
			deliveryService.criar(delivery);
			setItensSession(session, new Delivery());
		}
		
		
		return "redirect:/delivery/listar";
	}*/
	
	

}
