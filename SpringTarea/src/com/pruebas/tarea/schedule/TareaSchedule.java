package com.pruebas.tarea.schedule;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pruebas.tarea.entitades.Tarea;
import com.pruebas.tarea.servicios.TareaDao;

@Component
public class TareaSchedule implements Serializable {
	private static final long serialVersionUID = 1321092592770467192L;
	
	@Resource(name="tareaService")
	private TareaDao tareaService;

	public TareaSchedule() {
		System.out.println("TareaSchedule construido");
	}
	
	@Scheduled(fixedRate=10000)
	public void mostrarInfoTarea(){
		
		List<Tarea> tareas = tareaService.getTareas();
		
		System.out.println("Tareas pendientes: " + tareas);
	}
	

}
