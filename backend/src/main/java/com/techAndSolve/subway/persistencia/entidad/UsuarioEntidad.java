package com.techAndSolve.subway.persistencia.entidad;

import java.util.List;

public class UsuarioEntidad {
	private int rol;
	private List<RespuestaEntidad> respuestasObtenidas;
	private String identificacion;
	private String nombreUsuario;
	
	public UsuarioEntidad(int rol, List<RespuestaEntidad> respuestasObtenidas, String identificacion,
			String nombreUsuario) {
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

	public List<RespuestaEntidad> getRespuestasObtenidas() {
		return respuestasObtenidas;
	}

	public void setRespuestasObtenidas(List<RespuestaEntidad> respuestasObtenidas) {
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
