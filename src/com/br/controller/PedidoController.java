package com.br.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.model.Pedido;
import com.br.services.PedidoService;


@RequestMapping(value="pedido")
@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;

	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map, HttpSession session){
		
		List<Pedido> pedidos = pedidoService.listar();
		Collections.sort(pedidos);
		map.addAttribute("pedidos", pedidos);
		map.addAttribute("filtro", new Pedido());
		return "listarpedidos";
	}
	
	@RequestMapping(value="{id}/detalhar", method=RequestMethod.GET)
	public String detalhar(@PathVariable Long id, ModelMap map, HttpSession session){
		
		Pedido pedido = pedidoService.procurar(new Pedido(id));
		map.addAttribute("pedido", pedido);
		return "detalharpedido";
	}
		
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Pedido filtro, ModelMap map, HttpSession session){
		List<Pedido> pedidos = pedidoService.buscarFiltro(filtro);
		Collections.sort(pedidos);
		map.addAttribute("pedidos", pedidos);
		map.addAttribute("filtro", filtro);
		return "listarpedidos";
	}

	@RequestMapping(method=RequestMethod.GET, value="{id}/cancelar")
	public String cancelarPedido(@PathVariable Long id, ModelMap map) throws Exception{
		Pedido pedido = pedidoService.procurar(new Pedido(id));
		if(pedido.getStatus().equals("Pendente")){
			pedido.setStatus("Cancelado");
			pedidoService.atualizar(pedido);
		}
		return "redirect:/pedido/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/atender")
	public String atenderPedido(@PathVariable Long id, ModelMap map) throws Exception{
		Pedido pedido = pedidoService.procurar(new Pedido(id));
		if(pedido.getStatus().equals("Pendente")){
			pedido.setStatus("Atendido");
			pedidoService.atualizar(pedido);
		}
		return "redirect:/pedido/listar";
	}
	
	

}
