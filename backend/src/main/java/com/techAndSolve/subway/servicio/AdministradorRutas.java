package com.techAndSolve.subway.servicio;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techAndSolve.subway.dominio.Consulta;
import com.techAndSolve.subway.dominio.DatosUsuario;
import com.techAndSolve.subway.dominio.Estacion;
import com.techAndSolve.subway.dominio.RutaGeneral;
import com.techAndSolve.subway.dominio.Rutas;
import com.techAndSolve.subway.dominio.SubRuta;
import com.techAndSolve.subway.persistencia.interfaz.RutaGeneralDAO;
import com.techAndSolve.subway.persistencia.interfaz.RutasDAO;
import com.techAndSolve.subway.util.CalculadoraAritmetica;
import com.techAndSolve.subway.util.Dijkstra;
import com.techAndSolve.subway.util.VerificadorRutas;

public class AdministradorRutas {
	
	@Autowired
	RutaGeneralDAO rutaGeneralDAO;
	
	@Autowired
	RutasDAO rutasDAO;
	
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
	
	public List<SubRuta> obtenerListadoDeRutasASeguir(Consulta consulta){
		List<Estacion> estaciones = obtenerRutaMasCercana(consulta);
		Rutas rutas = rutasDAO.obtenerRutas();
		return VerificadorRutas.devolverRutasASeguir(estaciones, rutas);
	}
	
	public DatosUsuario obtenerDatosRequeridosPorElUsuario(Consulta consulta) {
		LinkedList<Estacion> rutaMasCorta = obtenerRutaMasCercana(consulta);
		List<SubRuta> subRutas = obtenerListadoDeRutasASeguir(consulta);
		int tiempo =  CalculadoraAritmetica.calcularTiempoTotalParaUnaRuta(subRutas, obtenerTiempo(consulta));
		return new DatosUsuario(tiempo, rutaMasCorta, subRutas);
	}
}
