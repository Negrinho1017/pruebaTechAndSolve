package com.techAndSolve.subway.dominio;

import java.util.LinkedList;

public class DatosUsuario {
	private int tiempo;
	private LinkedList<Estacion> rutaMasCorta;
	
	public DatosUsuario(int tiempo, LinkedList<Estacion> rutaMasCorta) {
		super();
		this.tiempo = tiempo;
		this.rutaMasCorta = rutaMasCorta;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public LinkedList<Estacion> getRutaMasCorta() {
		return rutaMasCorta;
	}

	public void setRutaMasCorta(LinkedList<Estacion> rutaMasCorta) {
		this.rutaMasCorta = rutaMasCorta;
	}
	
}
