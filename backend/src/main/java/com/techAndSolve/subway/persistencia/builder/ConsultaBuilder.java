package com.techAndSolve.subway.persistencia.builder;

import com.techAndSolve.subway.dominio.Consulta;
import com.techAndSolve.subway.persistencia.entidad.ConsultaEntidad;

public class ConsultaBuilder {
	public static Consulta convertirDeEntidadADominio(ConsultaEntidad consultaEntidad) {
		int estacionOrigen = consultaEntidad.getEstacionOrigen();
		int estacionDestino = consultaEntidad.getEstacionDestino();
		return new Consulta(estacionOrigen, estacionDestino);
	}
	
	public static ConsultaEntidad convertirDeDominioAEntidad(Consulta consulta) {
		int estacionOrigen = consulta.getEstacionOrigen();
		int estacionDestino = consulta.getEstacionDestino();
		return new ConsultaEntidad(estacionOrigen, estacionDestino);
	}

}
