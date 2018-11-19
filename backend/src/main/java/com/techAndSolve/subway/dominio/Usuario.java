package com.techAndSolve.subway.dominio;

import java.util.List;

public class Usuario {
	private int rol;
	private List<Respuesta> respuestasObtenidas;
	private String identificacion;
	private String nombreUsuario;
	
	
	public Usuario(int rol, List<Respuesta> respuestasObtenidas, String identificacion, String nombreUsuario) {
		super();
		this.rol = rol;
		this.respuestasObtenidas = respuestasObtenidas;
		this.identificacion = identificacion;
		this.nombreUsuario = nombreUsuario;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public List<Respuesta> getRespuestasObtenidas() {
		return respuestasObtenidas;
	}

	public void setRespuestasObtenidas(List<Respuesta> respuestasObtenidas) {
		this.respuestasObtenidas = respuestasObtenidas;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
}
