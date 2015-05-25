package com.pruebas;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("personaService")
@Transactional
public class PersonaService {
	
	private static Logger Log = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public PersonaService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Persona> getAll(){
		Log.debug("Leyendo todas las personas");
		
		Session session = sessionFactory.getCurrentSession();
		
		Query q = session.createQuery("from Persona");
		
		return q.list();
		
	}

}
