package com.techAndSolve.subway.servicio;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.techAndSolve.subway.dominio.Estacion;
import com.techAndSolve.subway.dominio.RutaGeneral;
import com.techAndSolve.subway.dominio.Rutas;
import com.techAndSolve.subway.persistencia.interfaz.RutaGeneralDAO;
import com.techAndSolve.subway.util.Dijkstra;

public class AdministradorDeRutas {
	
	@Autowired
	RutaGeneralDAO rutaGeneralDAO;
	/*@Autowired
	MongoOperations mongoOperations;
	
	private static final String RUTAS = "rutas";
	
	public AdministradorDeRutas(MongoOperations mongoOperations) {
		super();
		this.mongoOperations = mongoOperations;
	}
	
	public void probar() {
		Query pruebaPorId = query(where("idRutas").is(1));
		Rutas rutas = mongoOperations.find(pruebaPorId, Rutas.class, RUTAS).get(0);
		System.out.println(rutas.getRutaA().get(1));
		System.out.println(rutas.getRutaB().get(4));
		System.out.println(rutas.getRutaC().get(6));
		System.out.println(rutas.getRutaD().get(3));
		System.out.println(rutas.getRutaE().get(5));
		System.out.println(rutas.getRutaF().get(7));
	}
	
	public void guardar(RutaGeneral graph) {
		mongoOperations.save(graph, "rutaGeneral");
	}*/
	
	public LinkedList<Estacion> obtenerRutaMasCercana(int estacionOrigen, int estacionDestino){
		RutaGeneral rutaGeneral = rutaGeneralDAO.obtenerRutaGeneral();
		Dijkstra dijkstra = new Dijkstra(rutaGeneral);
        dijkstra.execute(rutaGeneral.getVertexes().get(estacionOrigen-1));
        return dijkstra.getPath(rutaGeneral.getVertexes().get(estacionDestino-1));
	}
	
	public int obtenerTiempo(int estacionOrigen, int estacionDestino){
		RutaGeneral rutaGeneral = rutaGeneralDAO.obtenerRutaGeneral();
		Dijkstra dijkstra = new Dijkstra(rutaGeneral);
        dijkstra.execute(rutaGeneral.getVertexes().get(estacionOrigen-1));
        return dijkstra.getShortestDistance(rutaGeneral.getVertexes().get(estacionDestino-1));
	}
}
