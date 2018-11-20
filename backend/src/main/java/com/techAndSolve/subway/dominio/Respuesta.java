package com.techAndSolve.subway.dominio;

import java.util.List;

public class Respuesta {
	private int tiempo;
	private Consulta consultaRealizada;
	private List<Estacion> estaciones;
	
	public Respuesta(int tiempo, Consulta consultaRealizada, List<Estacion> estaciones) {
		super();
		this.tiempo = tiempo;
		this.consultaRealizada = consultaRealizada;
		this.estaciones = estaciones;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public Consulta getConsultaRealizada() {
		return consultaRealizada;
	}

	public void setConsultaRealizada(Consulta consultaRealizada) {
		this.consultaRealizada = consultaRealizada;
	}

	public List<Estacion> getEstaciones() {
		return estaciones;
	}

	public void setEstaciones(List<Estacion> estaciones) {
		this.estaciones = estaciones;
	}
}
