package com.techAndSolve.subway.persistencia.interfaz;

import java.util.List;

import com.techAndSolve.subway.dominio.Respuesta;

public interface ConsultasYRespuestasDAO {
	public void crearRespuesta(Respuesta respuesta, String idUsuario);
	
	public List<Respuesta> obtenerRespuestasPorUsuario(String idUsuario);
	
	public void actualizarRespuestasUsuario(Respuesta respuesta, String idUsuario);
	
}
