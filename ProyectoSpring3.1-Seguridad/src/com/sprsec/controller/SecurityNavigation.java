package com.sprsec.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityNavigation {
	private static final Logger log = Logger.getLogger("controller");
	
	@RequestMapping(value="/user-login", method=RequestMethod.GET)
	public ModelAndView loginForm() {
		log.debug("SecurityNavigation: en el metodo loginForm()");
		return new ModelAndView("login-form");
	}
	
	@RequestMapping(value="/error-login", method=RequestMethod.GET)
	public ModelAndView invalidLogin() {
		log.debug("SecurityNavigation: en el metodo invalidLogin()");
		ModelAndView modelAndView = new ModelAndView("login-form");
		modelAndView.addObject("error", true);
		return modelAndView;
	}
	
	@RequestMapping(value="/success-login", method=RequestMethod.GET)
	public ModelAndView successLogin() {
		log.debug("SecurityNavigation: en el metodo successLogin()");
		return new ModelAndView("success-login");
	}

}
