package com.techAndSolve.subway.dominio;

import java.util.List;

public class Respuesta {
	private int tiempo;
	private Consulta consultaRealizada;
	private List<Consulta> consultasPorRuta;
	
	public Respuesta(int tiempo, Consulta consultaRealizada, List<Consulta> consultasPorRuta) {
		super();
		this.tiempo = tiempo;
		this.consultaRealizada = consultaRealizada;
		this.consultasPorRuta = consultasPorRuta;
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

	public List<Consulta> getConsultasPorRuta() {
		return consultasPorRuta;
	}

	public void setConsultasPorRuta(List<Consulta> consultasPorRuta) {
		this.consultasPorRuta = consultasPorRuta;
	}
	
}
