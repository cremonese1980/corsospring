package com.pruebas.tarea.servicios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.pruebas.tarea.entitades.Tarea;

@Service
public class TareaService implements TareaDao {
	
	@Resource(name="dataSource")
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;

	public TareaService() {
		System.out.println("UsuarioService construido");
	}
	
	@PostConstruct
	public void init(){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Tarea> getTareas() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query("select * from tarea", new TareaRowMapper());
		
	}
	
	private static final class TareaRowMapper implements RowMapper<Tarea>{

		@Override
		public Tarea mapRow(ResultSet rs, int rowNum) throws SQLException {
			Long idtarea = rs.getLong("idtarea");
			String contenido = rs.getString("contenido");
			Tarea tarea = new Tarea(idtarea, contenido);
			return tarea;
		}
		
	}


	@Override
	public void insertarTarea(Tarea tarea) {
		Object[] args = {tarea.getContenido()};
		jdbcTemplate.update(" Insert into tarea(contenido) "
				+ "values(?)", args);

	}

	@Override
	public void borrarTarea(Long id) {
		jdbcTemplate.update("delete from  tarea "
				+ "where idtarea = " + id);
		
	}


}
