package com.pruebas.tarea.servicios;

import java.util.List;

import com.pruebas.tarea.entitades.Tarea;

public interface TareaDao {

	public List<Tarea> getTareas();
	public void insertarTarea(Tarea tarea);
	public void borrarTarea(Long id);
}
