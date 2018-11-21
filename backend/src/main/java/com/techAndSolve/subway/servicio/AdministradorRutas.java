package com.techAndSolve.subway.servicio;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;

import com.techAndSolve.subway.dominio.Consulta;
import com.techAndSolve.subway.dominio.Estacion;
import com.techAndSolve.subway.dominio.RutaGeneral;
import com.techAndSolve.subway.persistencia.interfaz.RutaGeneralDAO;
import com.techAndSolve.subway.util.Dijkstra;

public class AdministradorRutas {
	
	@Autowired
	RutaGeneralDAO rutaGeneralDAO;
	
	public LinkedList<Estacion> obtenerRutaMasCercana(Consulta consulta){
		RutaGeneral rutaGeneral = rutaGeneralDAO.obtenerRutaGeneral();
		Dijkstra dijkstra = new Dijkstra(rutaGeneral);
        dijkstra.execute(rutaGeneral.getVertexes().get(consulta.getEstacionOrigen()-1));
        return dijkstra.getPath(rutaGeneral.getVertexes().get(
        		consulta.getEstacionDestino()-1));
	}
	
	public int obtenerTiempo(Consulta consulta){
		RutaGeneral rutaGeneral = rutaGeneralDAO.obtenerRutaGeneral();
		Dijkstra dijkstra = new Dijkstra(rutaGeneral);
        dijkstra.execute(rutaGeneral.getVertexes().get(consulta.getEstacionOrigen()-1));
        return dijkstra.getShortestDistance(rutaGeneral.getVertexes().get(
        		consulta.getEstacionDestino()-1));
	}
}
