package com.pruebas;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class ControladorPrincipal {

	private static Logger Log = Logger.getLogger("controller");
	
	@Autowired
	private PersonaService personaService;
	
	public ControladorPrincipal() {
		Log.debug("Construyendo controlador principal");
	}

	@RequestMapping(value="/persons", method=RequestMethod.GET )
	public String getPersons(Model model){
		Log.debug("Leyendo todas las personas desde el controlador");
		
		List<Persona> personas = personaService.getAll();
		model.addAttribute("personas", personas);
		return "personspage";
	}
	
}
