package com.techAndSolve.subway.persistencia.interfaz;

import java.util.List;

import com.techAndSolve.subway.dominio.Respuesta;

public interface ConsultasYRespuestasDAO {
	public void crearUsuario(Respuesta respuesta, String idUsuario);
	
	public List<Respuesta> obtenerRespuestasPorUsuario(String idUsuario);
	
	public boolean existeElUsuario(String idUsuario);
	
	public void actualizarUsuario(Respuesta respuesta, String idUsuario);
	
}