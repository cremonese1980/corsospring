package com.pruebas.tarea.controlador;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pruebas.tarea.entitades.Tarea;
import com.pruebas.tarea.servicios.TareaDao;

@Controller
@RequestMapping("/main")
public class TareaController {

	
	@Resource(name="tareaService")
	private TareaDao tareaService;
	
	public TareaController() {
	}

	
	@RequestMapping(value="/tareas", method=RequestMethod.GET )
	public String mostrarFormulario(Model model){
		
		List<Tarea> listado = tareaService.getTareas();
		
		model.addAttribute("tareaAttr", new Tarea());
		model.addAttribute("listado", listado);
		return "agregartarea";
		
	}
	
	@RequestMapping(value="/addTarea", method=RequestMethod.POST )
	public String inserirTarea(@ModelAttribute("tareaAttr")
			Tarea tarea, Model model){
		
		tareaService.insertarTarea(tarea);
		
		return "redirect:tareas";
		
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String borrarTarea(
			@RequestParam(value = "id", required = true) Long id, Model model) {

		tareaService.borrarTarea(id);
		return "redirect:tareas";

	}
	
	
}
