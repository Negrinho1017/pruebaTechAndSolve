package com.techAndSolve.subway.persistencia.entidad;

import java.util.List;

public class RutaGeneralEntidad {
	private List<EstacionEntidad> estaciones;
    private List<CaminoEntreEstacionesEntidad> caminosEntreEstaciones;
    
	public RutaGeneralEntidad(List<EstacionEntidad> estaciones,
			List<CaminoEntreEstacionesEntidad> caminosEntreEstaciones) {
		super();
		this.estaciones = estaciones;
		this.caminosEntreEstaciones = caminosEntreEstaciones;
	}

	public List<EstacionEntidad> getEstaciones() {
		return estaciones;
	}

	public void setEstaciones(List<EstacionEntidad> estaciones) {
		this.estaciones = estaciones;
	}

	public List<CaminoEntreEstacionesEntidad> getCaminosEntreEstaciones() {
		return caminosEntreEstaciones;
	}

	public void setCaminosEntreEstaciones(List<CaminoEntreEstacionesEntidad> caminosEntreEstaciones) {
		this.caminosEntreEstaciones = caminosEntreEstaciones;
	}
}
