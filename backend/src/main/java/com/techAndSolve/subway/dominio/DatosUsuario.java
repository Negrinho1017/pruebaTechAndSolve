package com.techAndSolve.subway.dominio;

import java.util.LinkedList;
import java.util.List;

public class DatosUsuario {
	private int tiempo;
	private LinkedList<Estacion> rutaMasCorta;
	private List<SubRuta> subRutas;
	
	public DatosUsuario(int tiempo, LinkedList<Estacion> rutaMasCorta, List<SubRuta> subRutas) {
		super();
		this.tiempo = tiempo;
		this.rutaMasCorta = rutaMasCorta;
		this.subRutas = subRutas;
	}

	public List<SubRuta> getSubRutas() {
		return subRutas;
	}

	public void setSubRutas(List<SubRuta> subRutas) {
		this.subRutas = subRutas;
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
