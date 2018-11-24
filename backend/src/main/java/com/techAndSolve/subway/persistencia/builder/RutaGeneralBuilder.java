package com.techAndSolve.subway.persistencia.builder;

import java.util.List;

import com.techAndSolve.subway.dominio.CaminoEntreEstaciones;
import com.techAndSolve.subway.dominio.Estacion;
import com.techAndSolve.subway.dominio.RutaGeneral;
import com.techAndSolve.subway.persistencia.entidad.RutaGeneralEntidad;

public class RutaGeneralBuilder {
	public static RutaGeneral convertirDeEntidadADominio(RutaGeneralEntidad rutaGeneralEntidad) {
		List<Estacion> estaciones = EstacionBuilder.convertirListaDeEntidadADominio(
				rutaGeneralEntidad.getEstaciones());
	    List<CaminoEntreEstaciones> caminosEntreEstaciones = CaminoEntreEstacionesBuilder.convertirListaDeEntidadADominio(
	    		rutaGeneralEntidad.getCaminosEntreEstaciones());
	    return new RutaGeneral(estaciones, caminosEntreEstaciones);
	}
}
