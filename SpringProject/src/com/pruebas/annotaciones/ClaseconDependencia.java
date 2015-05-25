package com.pruebas.annotaciones;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ClaseconDependencia {
	
	private IDemo demo;

//	@Autowired
//	@Qualifier(value="demoImpl2") /*Qualifier per capire quale delle due implementazioni */
	@Resource(name="demoImpl1")
	public void setDemo(IDemo demo) {
		System.out.println("Inyectando referencia");
		this.demo = demo;
	}
	
	
	public void comprobar(){
		String valor = "Curso de Spring MVC/REST";
		demo.mostrarVAlor(valor);
	}

}
