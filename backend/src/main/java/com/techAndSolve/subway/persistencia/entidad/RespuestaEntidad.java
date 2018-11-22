package com.techAndSolve.subway.persistencia.entidad;

import java.util.List;

public class RespuestaEntidad {
	private int tiempo;
	private ConsultaEntidad consultaRealizada;
	private List<EstacionEntidad> estaciones;
	
	public RespuestaEntidad(int tiempo, ConsultaEntidad consultaRealizada, List<EstacionEntidad> estaciones) {
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

	public ConsultaEntidad getConsultaRealizada() {
		return consultaRealizada;
	}

	public void setConsultaRealizada(ConsultaEntidad consultaRealizada) {
		this.consultaRealizada = consultaRealizada;
	}

	public List<EstacionEntidad> getEstaciones() {
		return estaciones;
	}

	public void setEstaciones(List<EstacionEntidad> estaciones) {
		this.estaciones = estaciones;
	}
}
