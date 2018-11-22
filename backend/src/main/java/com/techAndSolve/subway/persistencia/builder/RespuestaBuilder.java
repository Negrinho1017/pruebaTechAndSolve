package com.techAndSolve.subway.persistencia.builder;

import java.util.ArrayList;
import java.util.List;

import com.techAndSolve.subway.dominio.Consulta;
import com.techAndSolve.subway.dominio.Estacion;
import com.techAndSolve.subway.dominio.Respuesta;
import com.techAndSolve.subway.persistencia.entidad.ConsultaEntidad;
import com.techAndSolve.subway.persistencia.entidad.EstacionEntidad;
import com.techAndSolve.subway.persistencia.entidad.RespuestaEntidad;

public class RespuestaBuilder {
	
	public static Respuesta convertirDeEntidadADominio(RespuestaEntidad respuestaEntidad) {
		int tiempo = respuestaEntidad.getTiempo();
		Consulta consultaRealizada = ConsultaBuilder.convertirDeEntidadADominio(
				respuestaEntidad.getConsultaRealizada());
		List<Estacion> estaciones = EstacionBuilder.convertirListaDeEntidadADominio(
					respuestaEntidad.getEstaciones());
		return new Respuesta(tiempo, consultaRealizada, estaciones);
	}
	
	public static RespuestaEntidad convertirDeDominioAEntidad(Respuesta respuesta) {
		int tiempo = respuesta.getTiempo();
		ConsultaEntidad consultaRealizada = ConsultaBuilder.convertirDeDominioAEntidad(
				respuesta.getConsultaRealizada());
		List<EstacionEntidad> estaciones = EstacionBuilder.convertirListaDeDominioAEntidad(
				respuesta.getEstaciones());
		return new RespuestaEntidad(tiempo, consultaRealizada, estaciones);
	}
	
	public static List<Respuesta> convertirListaDeEntidadADominio(List<RespuestaEntidad> respuestasEntidad) {
		List<Respuesta> respuestas = new ArrayList<>();
		for(RespuestaEntidad respuestaEntidad : respuestasEntidad) {
			respuestas.add(convertirDeEntidadADominio(respuestaEntidad));
		}
		return respuestas;
	}
	
	public static List<RespuestaEntidad> convertirListaDeDominioAEntidad(List<Respuesta> respuestas) {
		List<RespuestaEntidad> respuestasEntidad = new ArrayList<>();
		for(Respuesta respuesta : respuestas) {
			respuestasEntidad.add(convertirDeDominioAEntidad(respuesta));
		}
		return respuestasEntidad;
	}
}
