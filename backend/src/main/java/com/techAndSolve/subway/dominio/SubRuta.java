package com.techAndSolve.subway.dominio;

public class SubRuta {
	private String nombre;
	private int estacionOrigen;
	private int estacionDestino;
	
	public SubRuta(String nombre, int estacionOrigen, int estacionDestino) {
		super();
		this.nombre = nombre;
		this.estacionOrigen = estacionOrigen;
		this.estacionDestino = estacionDestino;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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