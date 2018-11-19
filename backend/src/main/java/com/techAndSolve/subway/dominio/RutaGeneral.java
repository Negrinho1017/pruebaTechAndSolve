package com.techAndSolve.subway.dominio;

import java.util.List;

public class RutaGeneral {
    private List<Estacion> estaciones;
    private List<CaminoEntreEstaciones> caminosEntreEstaciones;

    
    public RutaGeneral() {}

	public RutaGeneral(List<Estacion> vertexes, List<CaminoEntreEstaciones> edges) {
        this.estaciones = vertexes;
        this.caminosEntreEstaciones = edges;
    }

    public List<Estacion> getVertexes() {
        return estaciones;
    }

    public List<CaminoEntreEstaciones> getEdges() {
        return caminosEntreEstaciones;
    }
}
