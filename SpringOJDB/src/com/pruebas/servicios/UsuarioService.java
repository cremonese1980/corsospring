package com.pruebas.servicios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.pruebas.entitades.Usuario;

@Service
public class UsuarioService implements UsuariosDao {
	
	@Resource(name="dataSource")
	private DataSource dataSource;

	public UsuarioService() {
		System.out.println("UsuarioService construido");
	}

	@Override
	public List<Usuario> getUsuarios() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query("select * from usuarios", new UsuariosRowMapper());
		
	}
	
	private static final class UsuariosRowMapper implements RowMapper<Usuario>{

		@Override
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			Long idusuario = rs.getLong("idUsuario");
			String nombre = rs.getString("nombre");
			String appellido = rs.getString("appellido");
			String telefono = rs.getString("telefono");
			String ciudad= rs.getString("ciudad");
			Usuario usuario = new Usuario(idusuario, nombre, appellido, telefono, ciudad);
			
			
			return usuario;
		}
		
	}

	@Override
	public Usuario buscarUsuario(Usuario usuario) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		List<Usuario> usuarioList = jdbcTemplate.query("Select * from Usuarios "
				+ "where idusuario = " + usuario.getIdusuario(),
				new UsuariosRowMapper());
		
		if(usuarioList.isEmpty()){
			throw new ObjectRetrievalFailureException(Usuario.class, usuario.getIdusuario());
		}
		
		return usuarioList.get(0);
		
	}

	@Override
	public void insertarUsuario(Usuario usuario) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = {usuario.getNombre(), usuario.getAppellido(), usuario.getTelefono(), usuario.getCiudad()};
		jdbcTemplate.update(" Insert into Usuarios(nombre, appellido, telefono, ciudad) "
				+ "values(?, ?, ?, ?)", args);

	}

	@Override
	public void eliminarUsuario(Long idusuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

	}

}
