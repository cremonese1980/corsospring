package com.pruebas;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;

public class AdivinarNumero implements Serializable {
	
	private static final long serialVersionUID = 8147069827431738031L;
	
	private static Random random = new Random();
	
	private Calendar fromDate = null;
	private int respuesta = 0;
	private int intentos = 0;
	private VALOR resultado;
	
	enum VALOR{
		MUY_ALTO, MUY_BAJO, CORRECTO, INVALIDO
	}

	public AdivinarNumero() {
	}

	public VALOR comprobarValor(int entrada){
		
		if(entrada <0 || entrada > 100){
			setResultado(VALOR.INVALIDO);
		}else{
			intentos++;
			if(respuesta<entrada){
				setResultado(VALOR.MUY_ALTO);
			}else if(respuesta>entrada){
				setResultado(VALOR.MUY_BAJO);
			}else{
				setResultado(VALOR.CORRECTO);
			}
		}
		
		return getResultado();
	}
	
	public long getDuracion(){
		Calendar now = Calendar.getInstance();
		long milis = now.getTimeInMillis() - fromDate.getTimeInMillis();
		return milis/1000;
	}

	public Calendar getFromDate() {
		return fromDate;
	}

	public void setFromDate(Calendar fromDate) {
		this.fromDate = fromDate;
	}

	public int getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(int respuesta) {
		this.respuesta = respuesta;
	}

	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

	public VALOR getResultado() {
		return resultado;
	}

	public void setResultado(VALOR resultado) {
		this.resultado = resultado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
