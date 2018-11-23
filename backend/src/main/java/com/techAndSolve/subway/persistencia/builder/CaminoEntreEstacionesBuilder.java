package com.techAndSolve.subway.persistencia.builder;

import java.util.ArrayList;
import java.util.List;

import com.techAndSolve.subway.dominio.CaminoEntreEstaciones;
import com.techAndSolve.subway.dominio.Estacion;
import com.techAndSolve.subway.persistencia.entidad.CaminoEntreEstacionesEntidad;

public class CaminoEntreEstacionesBuilder {
	public static CaminoEntreEstaciones convertirDeEntidadADominio(CaminoEntreEstacionesEntidad caminoEntreEstacionesEntidad) {
		String id = caminoEntreEstacionesEntidad.getId();
	    Estacion source = EstacionBuilder.convertirDeEntidadADominio(caminoEntreEstacionesEntidad.getSource());
	    Estacion destination = EstacionBuilder.convertirDeEntidadADominio(caminoEntreEstacionesEntidad.getDestination());
	    int weight = caminoEntreEstacionesEntidad.getWeight();
	    return new CaminoEntreEstaciones(id, source, destination, weight);
	}
	
	public static List<CaminoEntreEstaciones> convertirListaDeEntidadADominio(List<CaminoEntreEstacionesEntidad> caminosEntreEstacionesEntidad) {
		List<CaminoEntreEstaciones> caminosEntreEstaciones = new ArrayList<>();
		for(CaminoEntreEstacionesEntidad caminoEntreEstacionesEntidad : caminosEntreEstacionesEntidad) {
			caminosEntreEstaciones.add(convertirDeEntidadADominio(caminoEntreEstacionesEntidad));
		}
		return caminosEntreEstaciones;
	}
}
