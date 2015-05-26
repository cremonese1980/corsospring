package com.pruebas.controladores;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pruebas.entitades.Usuario;
import com.pruebas.servicios.UsuariosDao;

@Controller
@RequestMapping("/main")
public class UsuarioController {

	
	@Resource(name="usuarioService")
	private UsuariosDao usuarioService;
	
	public UsuarioController() {
	}

	@RequestMapping(value="/articulos", method=RequestMethod.GET )
	public ModelAndView leerArticulos(){
		
		ModelAndView mav = new ModelAndView("listadousuarios");
		List<Usuario> listado = usuarioService.getUsuarios();
		mav.addObject("listado", listado);
		return mav;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET )
	public String mostrarFormulario(Model model){
		
		model.addAttribute("usuarioAttr", new Usuario());
		return "agregarusuario";
		
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST )
	public String inserirUsuario(@ModelAttribute("usuarioAttr")
			Usuario usuario, Model model){
		
		usuarioService.insertarUsuario(usuario);
		
//		List<Usuario> listado = usuarioService.getUsuarios();
//		model.addAttribute("listado", listado);
//		return "listadousuarios";
		
		
		return "redirect:articulos";
		
	}
	
}
