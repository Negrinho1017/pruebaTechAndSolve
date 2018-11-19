package com.techAndSolve.subway.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.techAndSolve.subway.dominio.CaminoEntreEstaciones;
import com.techAndSolve.subway.dominio.Estacion;
import com.techAndSolve.subway.dominio.RutaGeneral;

public class DijkstraTest {
	
	@Test
	public void getTimeTest() {
		Estacion v1 = new Estacion("1","1");
		Estacion v2 = new Estacion("2","2");
		List<Estacion> estaciones = new ArrayList<>();
		estaciones.add(v1);
		estaciones.add(v2);
		CaminoEntreEstaciones e1_2 = new CaminoEntreEstaciones("1_2", v1, v2, 6);
		CaminoEntreEstaciones e1_2inv = new CaminoEntreEstaciones("1_2", v2, v1, 11);
		List<CaminoEntreEstaciones> caminosEntreEstaciones = new ArrayList<>();
		caminosEntreEstaciones.add(e1_2);
		caminosEntreEstaciones.add(e1_2inv);
		RutaGeneral rutaGeneral = new RutaGeneral(estaciones, caminosEntreEstaciones);
		Dijkstra dijkstra = new Dijkstra(rutaGeneral);
		assertEquals(dijkstra.getTime(estaciones.get(0), estaciones.get(1)), 6);
		assertEquals(dijkstra.getTime(estaciones.get(1), estaciones.get(0)), 11);
	}
	
	@Test(expected = Exception.class)
	public void getTimeTestWithException() {
		Estacion v1 = new Estacion("1","1");
		Estacion v2 = new Estacion("2","2");
		Estacion v3 = new Estacion("3","3");
		List<Estacion> estaciones = new ArrayList<>();
		estaciones.add(v1);
		estaciones.add(v2);
		estaciones.add(v3);
		CaminoEntreEstaciones e1_2 = new CaminoEntreEstaciones("1_2", v1, v2, 6);
		CaminoEntreEstaciones e1_2inv = new CaminoEntreEstaciones("1_2", v2, v1, 11);
		CaminoEntreEstaciones e2_3 = new CaminoEntreEstaciones("2_3", v2, v3, 10);
		List<CaminoEntreEstaciones> caminosEntreEstaciones = new ArrayList<>();
		caminosEntreEstaciones.add(e1_2);
		caminosEntreEstaciones.add(e1_2inv);
		caminosEntreEstaciones.add(e2_3);
		RutaGeneral rutaGeneral = new RutaGeneral(estaciones, caminosEntreEstaciones);
		Dijkstra dijkstra = new Dijkstra(rutaGeneral);
		assertEquals(dijkstra.getTime(estaciones.get(0), estaciones.get(2)), 16);
	}
	
	@Test
	public void getPathTest() {
		Estacion v1 = new Estacion("1","1");
		Estacion v2 = new Estacion("2","2");
		Estacion v3 = new Estacion("3","3");
		List<Estacion> estaciones = new ArrayList<>();
		estaciones.add(v1);
		estaciones.add(v2);
		estaciones.add(v3);
		CaminoEntreEstaciones e1_2 = new CaminoEntreEstaciones("1_2", v1, v2, 6);
		CaminoEntreEstaciones e1_2inv = new CaminoEntreEstaciones("2_1", v2, v1, 11);
		CaminoEntreEstaciones e2_3 = new CaminoEntreEstaciones("2_3", v2, v3, 10);
		List<CaminoEntreEstaciones> caminosEntreEstaciones = new ArrayList<>();
		caminosEntreEstaciones.add(e1_2);
		caminosEntreEstaciones.add(e1_2inv);
		caminosEntreEstaciones.add(e2_3);
		RutaGeneral rutaGeneral = new RutaGeneral(estaciones, caminosEntreEstaciones);
		Dijkstra dijkstra = new Dijkstra(rutaGeneral);
		dijkstra.execute(estaciones.get(0));
		assertEquals(3, dijkstra.getPath(estaciones.get(2)).size());
		assertEquals("1", dijkstra.getPath(estaciones.get(2)).get(0).getId());
		assertEquals("2", dijkstra.getPath(estaciones.get(2)).get(1).getId());
		assertEquals("3", dijkstra.getPath(estaciones.get(2)).get(2).getId());
	}
}
