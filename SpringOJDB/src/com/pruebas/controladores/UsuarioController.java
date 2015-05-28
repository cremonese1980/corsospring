package com.pruebas.controladores;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pruebas.entitades.Usuario;
import com.pruebas.servicios.UsuariosDao;

@Controller
@RequestMapping("/main")
@Scope("request")
@Transactional(propagation=Propagation.REQUIRED)
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
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@RequestMapping(value="/add", method=RequestMethod.POST )
	@ExceptionForRollback
	public String inserirUsuario(@ModelAttribute("usuarioAttr")
			Usuario usuario, Model model){
		
		usuarioService.insertarUsuario(usuario);
		
		return "redirect:articulos";
		
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET )
	public String verUsuario(@RequestParam(value="id", required=true) Long id, Model model){
		
		
		model.addAttribute("usuarioAttr", usuarioService.buscarUsuario(id));
		
		return "editarusuario";
		
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST )
	public String modificarUsuario(@ModelAttribute("usuarioAttr") Usuario usuario,
			@RequestParam(value="id", required=true) Long id, Model model){
		
		usuario.setIdusuario(id);
		
		usuarioService.modificarUsuario(usuario);
		
		return "redirect:articulos";
		
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET )
	public String borrarUsuario(@RequestParam(value="id", required=true) Long id, Model model){
		
		usuarioService.eliminarUsuario(id);
		return "redirect:articulos";
		
	}
	
	
	
	
}
