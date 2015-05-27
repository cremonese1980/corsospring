package com.pruebas.tarea.jmx;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import com.pruebas.tarea.servicios.TareaDao;

@Component
@ManagedResource(objectName="Ventura24:name=tareajmx",
		description="Gestion tareas")
public class TareaJMX implements Serializable {
	
	@Resource(name="tareaService")
	private TareaDao tareaService;
	
	private String nrTareas;

	private static final long serialVersionUID = 8382169223187588868L;
	

	public TareaJMX() {
		System.out.println("Tarea JMX construido");
	}
	
	@PostConstruct
	public void inicio(){
		nrTareas = "" + tareaService.getTareas().size();
	}


	@ManagedAttribute
	public String getNrTareas() {
		return "" + tareaService.getTareas().size();
	}

	@ManagedAttribute(description="Nr de tareas pendientes")
	public void setUsuario(String nrTareas) {
		this.nrTareas = nrTareas;
	}
	
//	@ManagedOperation(description="suma de cantidades")
//	@ManagedOperationParameters({@ManagedOperationParameter(name="c1", description="Cantidad c1"),
//		@ManagedOperationParameter(name="c2", description="Cantidad c2")})
//	public int sumar(int c1, int c2){
//		
//		return c1+c2;
//	}
	
	

}
