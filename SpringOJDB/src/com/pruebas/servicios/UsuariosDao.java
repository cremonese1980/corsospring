package com.pruebas.servicios;

import java.util.List;

import com.pruebas.entitades.Usuario;

public interface UsuariosDao {

	public List<Usuario> getUsuarios();
	public Usuario buscarUsuario(Long id);
	public void insertarUsuario(Usuario usuario);
	public void eliminarUsuario(Long idusuario);
	public void modificarUsuario(Usuario usuario);
}
