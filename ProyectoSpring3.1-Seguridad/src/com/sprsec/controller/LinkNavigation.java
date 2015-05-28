package com.sprsec.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkNavigation {
	private static final Logger log = Logger.getLogger("controller");

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homePage() {
		log.debug("LinkNavigation: en el metodo homePage()");
		return new ModelAndView("home");
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/ciccio/method-security", method = RequestMethod.GET)
	public String getCommonPage() {
		log.debug("------Seguridad a nivel de metodo, role permitido: ROLE_ADMIN");
		return "method-security";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView indexPage() {
		log.debug("LinkNavigation: en el metodo indexPage()");
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/sec/moderation", method = RequestMethod.GET)
	public ModelAndView moderatorPage() {
		log.debug("LinkNavigation: en el metodo moderatorPage()");
		return new ModelAndView("moderation");
	}

	@RequestMapping(value = "/admin/first", method = RequestMethod.GET)
	public ModelAndView firstAdminPage() {
		log.debug("LinkNavigation: en el metodo firstAdminPage()");
		return new ModelAndView("admin-first");
	}

	@RequestMapping(value = "/admin/second", method = RequestMethod.GET)
	public ModelAndView secondAdminPage() {
		log.debug("LinkNavigation: en el metodo secondAdminPage()");
		return new ModelAndView("admin-second");
	}

	// Para capturar el error: 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", "Hola " + user.getName() + 
					        ", no tienes permisos para visitar esta pagina");
		} else {
			model.addObject("msg", "no tienes permisos para visitar esta pagina");
		}
		model.setViewName("403");
		return model;

	}

}
