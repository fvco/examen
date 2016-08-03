package examen.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import examen.modelo.Pendiente;
import examen.service.PendienteService;

@Controller
@RequestMapping(value = "/pendientes")
public class PendienteController {

	@Autowired
	PendienteService pendienteService;

	@RequestMapping(value = "")
	public String getIndex(Model model) {
		agregarListaPendientes(model);
		model.addAttribute("pendiente", new Pendiente());
		return "pendientes";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, @Valid Pendiente pendiente, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			if (pendiente.getId() == 0) {
				pendienteService.add(pendiente);
			} else {
				pendienteService.edit(pendiente);
			}
			return "redirect:../pendientes";
		}
		agregarListaPendientes(model);
		return "pendientes";
	}
	
	@RequestMapping(value = "getPendiente", method = { RequestMethod.POST })
	@ResponseBody
	public Pendiente getPendiente(@RequestParam(value = "id", required = true) long id){
		return pendienteService.getPendiente(id);
	}
	
	@RequestMapping(value = "deletePendiente", method = { RequestMethod.POST })
	@ResponseBody
	public String deletePendiente(@RequestParam(value = "id", required = true) long id){
		pendienteService.delete(id);
		return "ok";
	}

	private void agregarListaPendientes(Model model){
		ArrayList<Pendiente> lista = (ArrayList<Pendiente>) pendienteService.getPendientes();
		model.addAttribute("lista", lista);
	}
	
}
