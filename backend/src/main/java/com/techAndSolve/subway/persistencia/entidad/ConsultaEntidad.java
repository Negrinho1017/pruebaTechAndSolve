package com.techAndSolve.subway.persistencia.entidad;

public class ConsultaEntidad {
	private int estacionOrigen;
	private int estacionDestino;
	
	public ConsultaEntidad(int estacionOrigen, int estacionDestino) {
		super();
		this.estacionOrigen = estacionOrigen;
		this.estacionDestino = estacionDestino;
	}

	public int getEstacionOrigen() {
		return estacionOrigen;
	}

	public void setEstacionOrigen(int estacionOrigen) {
		this.estacionOrigen = estacionOrigen;
	}

	public int getEstacionDestino() {
		return estacionDestino;
	}

	public void setEstacionDestino(int estacionDestino) {
		this.estacionDestino = estacionDestino;
	}
}
