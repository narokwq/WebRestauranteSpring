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

import com.br.model.Mesa;
import com.br.model.Reserva;
import com.br.model.Usuario;
import com.br.services.MesaService;
import com.br.services.ReservaService;

@RequestMapping(value = "reserva")
@Controller
public class ReservaController {

	@Autowired
	private ReservaService reserveService;
	@Autowired
	private MesaService mesaService;

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public String list(ModelMap map) {

		List<Reserva> reservas = reserveService.listar();
		map.addAttribute("reservas", reservas);
		map.addAttribute("filtro", new Reserva());
		map.addAttribute("mesaOpcao");
		return "listarreserva";
	}

	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String createForm(ModelMap map) {
		map.addAttribute("mesaOpcao");
		map.addAttribute("reserva", new Reserva());
		return "cadastroreserva";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/form")
	public String updateForm(@PathVariable Long id, ModelMap map) {
		Mesa mesa = mesaService.procurar(new Mesa(id));
		Map<Long,String> mesas = selectMesaLista();
		mesas.put(mesa.getId(), mesa.getDescricao());
		map.addAttribute("mesa", mesa);
		return "cadastromesa";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}/remove")
	public String desativarCardapio(@PathVariable Long id, ModelMap map) throws Exception {
		mesaService.remover(new Mesa(id));
		return "redirect:/mesa/listar";
	}

	@RequestMapping(method = RequestMethod.POST, value = "save")
	public String save(@Valid @ModelAttribute("reserva") Reserva reserva, BindingResult result, HttpSession session) throws Exception {
		if (reserva.hasValidId()) {
			reserveService.atualizar(reserva);
		} else {
			reserva.setFuncionario((Usuario) session.getAttribute("usuario"));
			if(reserva.getDataInicio().after(reserva.getDataFim())){
				result.rejectValue("dataInicio", null, "Data inicial maior que final");
				return "cadastroreserva";
			}
			try {
				reserveService.criar(reserva);
			} catch (Exception e) {
				result.rejectValue("", "erro.horario", e.getMessage());
				return "cadastroreserva";
			}
			
		}
		return "redirect:/reserva/listar";
	}

	@RequestMapping(value = "filtrar", method = RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Reserva filtro, ModelMap map) {
		List<Reserva> reservas = reserveService.buscarFiltro(filtro);
		map.addAttribute("reservas", reservas);
		map.addAttribute("filtro", filtro);
		map.addAttribute("mesaOpcao");
		return "listarreserva";
	}

	public Map<Long, String> selectMesaLista() {

		Map<Long, String> mesas = new HashMap<>();

		for (Mesa mesa : mesaService.listar()) {
			mesas.put(mesa.getId(), mesa.getDescricao());
		}
		return mesas;
	}
	
	@ModelAttribute(value="mesaOpcao")
	public Map<Long, String > selectStatus(){
		Map<Long, String> status = new HashMap<>();  
		List<Mesa> mesas = mesaService.listarReserva();
		if(mesas != null)
			for(Mesa mesa :mesas){
				status.put(mesa.getId(), mesa.getDescricao());
			}	 		 
		return status;
	}

}
