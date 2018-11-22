package com.techAndSolve.subway.persistencia.builder;

import java.util.ArrayList;
import java.util.List;

import com.techAndSolve.subway.dominio.Estacion;
import com.techAndSolve.subway.persistencia.entidad.EstacionEntidad;

public class EstacionBuilder {
	public static Estacion convertirDeEntidadADominio(EstacionEntidad estacionEntidad) {
		String id = estacionEntidad.getId();
	    String name = estacionEntidad.getId();
		return new Estacion(id, name);
	}
	
	public static EstacionEntidad convertirDeDominioAEntidad(Estacion estacion) {
		String id = estacion.getId();
	    String name = estacion.getId();
		return new EstacionEntidad(id, name);
	}
	
	public static List<Estacion> convertirListaDeEntidadADominio(List<EstacionEntidad> estacionesEntidad) {
		List<Estacion> estaciones = new ArrayList<>();
		for(EstacionEntidad estacionEntidad : estacionesEntidad) {
			estaciones.add(convertirDeEntidadADominio(estacionEntidad));
		}
		return estaciones;
	}
	
	public static List<EstacionEntidad> convertirListaDeDominioAEntidad(List<Estacion> estaciones) {
		List<EstacionEntidad> estacionesEntidad = new ArrayList<>();
		for(Estacion estacion : estaciones) {
			estacionesEntidad.add(convertirDeDominioAEntidad(estacion));
		}
		return estacionesEntidad;
	}
}
