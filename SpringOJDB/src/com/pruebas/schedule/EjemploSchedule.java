package com.pruebas.schedule;

import java.io.Serializable;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EjemploSchedule implements Serializable {
	private static final long serialVersionUID = 1321092592770467192L;

	public EjemploSchedule() {
		System.out.println("EjemploSchedule construido");
	}
	
	@Scheduled(fixedRate=10000)
	public void mostrarInfoJVM(){
		Runtime rt = Runtime.getRuntime();
		double freemem = rt.freeMemory();
		double totalmem = rt.totalMemory();
		System.out.println("Memoria total: " + totalmem +
				", Memoria libre: " + freemem +
				", Hora: " + new Date());
	}
	
	@Scheduled(cron="*/5 * * * * MON-FRI")
	public void mostrarLogin(){
		String user = System.getProperty("user.name");
		String so = System.getProperty("os.name");
		System.out.println("Usuario: " + user +
				", S.O.: " + so +
				", Hora: " + new Date());
	}

}
