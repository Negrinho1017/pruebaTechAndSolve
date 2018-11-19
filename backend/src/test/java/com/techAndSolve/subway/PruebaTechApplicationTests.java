package com.techAndSolve.subway;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.techAndSolve.subway.dominio.CaminoEntreEstaciones;
import com.techAndSolve.subway.dominio.RutaGeneral;
import com.techAndSolve.subway.persistencia.interfaz.RutaGeneralDAO;
import com.techAndSolve.subway.dominio.Estacion;
import com.techAndSolve.subway.servicio.AdministradorDeRutas;
import com.techAndSolve.subway.util.Dijkstra;

@SpringBootTest(classes = SubwayApplication.class)
@RunWith(SpringRunner.class)
public class PruebaTechApplicationTests {
	
	@Autowired
	AdministradorDeRutas administradorDeRutas;
	
	@Autowired
	RutaGeneralDAO rutaGeneralDAO;
	
	@Test
	public void contextLoads() {
		//administradorDeRutas.probar();
	}
	
	/*@Test
	public void dijkstraTest() {
		Estacion v1 = new Estacion("1","1");
		Estacion v2 = new Estacion("2","2");
		Estacion v3 = new Estacion("3","3");
		Estacion v4 = new Estacion("4","4");
		Estacion v5 = new Estacion("5","5");
		Estacion v6 = new Estacion("6","6");
		Estacion v7 = new Estacion("7","7");
		Estacion v8 = new Estacion("8","8");
		Estacion v9 = new Estacion("9","9");
		Estacion v10 = new Estacion("10","10");
		Estacion v11 = new Estacion("11","11");
		Estacion v12 = new Estacion("12","12");
		Estacion v13 = new Estacion("13","13");
		Estacion v14 = new Estacion("14","14");
		Estacion v15 = new Estacion("15","15");
		List<Estacion> estaciones = new ArrayList<>();
		estaciones.add(v1);
		estaciones.add(v2);
		estaciones.add(v3);
		estaciones.add(v4);
		estaciones.add(v5);
		estaciones.add(v6);
		estaciones.add(v7);
		estaciones.add(v8);
		estaciones.add(v9);
		estaciones.add(v10);
		estaciones.add(v11);
		estaciones.add(v12);
		estaciones.add(v13);
		estaciones.add(v14);
		estaciones.add(v15);
		//Directos
		CaminoEntreEstaciones e1_2 = new CaminoEntreEstaciones("1_2", v1, v2, 4);
		CaminoEntreEstaciones e2_3 = new CaminoEntreEstaciones("2_3", v2, v3, 4);
		CaminoEntreEstaciones e3_7 = new CaminoEntreEstaciones("3_7", v3, v7, 4);
		CaminoEntreEstaciones e7_4 = new CaminoEntreEstaciones("7_4", v7, v4, 4);
		CaminoEntreEstaciones e4_5 = new CaminoEntreEstaciones("4_5", v4, v5, 4);
		CaminoEntreEstaciones e5_6 = new CaminoEntreEstaciones("5_6", v5, v6, 4);
		CaminoEntreEstaciones e2_11 = new CaminoEntreEstaciones("2_11", v2, v11, 4);
		CaminoEntreEstaciones e11_12 = new CaminoEntreEstaciones("11_12", v11, v12, 4);
		CaminoEntreEstaciones e12_13 = new CaminoEntreEstaciones("12_13", v12, v13, 4);
		CaminoEntreEstaciones e13_14 = new CaminoEntreEstaciones("13_14", v13, v14, 4);
		CaminoEntreEstaciones e9_14 = new CaminoEntreEstaciones("9_14", v9, v14, 4);
		CaminoEntreEstaciones e14_15 = new CaminoEntreEstaciones("14_15", v14, v15, 4);
		CaminoEntreEstaciones e9_10 = new CaminoEntreEstaciones("9_10", v9, v10, 4);
		CaminoEntreEstaciones e7_8 = new CaminoEntreEstaciones("7_8", v7, v8, 4);
		CaminoEntreEstaciones e8_9 = new CaminoEntreEstaciones("8_9", v8, v9, 4);

		//Inversos
		CaminoEntreEstaciones e1_2inv = new CaminoEntreEstaciones("1_2", v2, v1, 4);
		CaminoEntreEstaciones e2_3inv = new CaminoEntreEstaciones("2_3", v3, v2, 4);
		CaminoEntreEstaciones e3_7inv = new CaminoEntreEstaciones("3_7", v7, v3, 4);
		CaminoEntreEstaciones e7_4inv = new CaminoEntreEstaciones("7_4", v4, v7, 4);
		CaminoEntreEstaciones e4_5inv = new CaminoEntreEstaciones("4_5", v5, v4, 4);
		CaminoEntreEstaciones e5_6inv = new CaminoEntreEstaciones("5_6", v6, v5, 4);
		CaminoEntreEstaciones e2_11inv = new CaminoEntreEstaciones("2_11", v11, v2, 4);
		CaminoEntreEstaciones e11_12inv = new CaminoEntreEstaciones("11_12", v12, v11, 4);
		CaminoEntreEstaciones e12_13inv = new CaminoEntreEstaciones("12_13", v13, v12, 4);
		CaminoEntreEstaciones e13_14inv = new CaminoEntreEstaciones("13_14", v14, v13, 4);
		CaminoEntreEstaciones e9_14inv = new CaminoEntreEstaciones("9_14", v14, v9, 4);
		CaminoEntreEstaciones e14_15inv = new CaminoEntreEstaciones("14_15", v15, v14, 4);
		CaminoEntreEstaciones e9_10inv = new CaminoEntreEstaciones("9_10", v10, v9, 4);
		CaminoEntreEstaciones e7_8inv = new CaminoEntreEstaciones("7_8", v8, v7, 4);
		CaminoEntreEstaciones e8_9inv = new CaminoEntreEstaciones("8_9", v9, v8, 4);
		
		List<CaminoEntreEstaciones> caminosEntreEstaciones = new ArrayList<>();
		
		//directos
		caminosEntreEstaciones.add(e1_2);
		caminosEntreEstaciones.add(e2_3);
		caminosEntreEstaciones.add(e3_7);
		caminosEntreEstaciones.add(e7_4);
		caminosEntreEstaciones.add(e4_5);
		caminosEntreEstaciones.add(e5_6);
		caminosEntreEstaciones.add(e2_11);
		caminosEntreEstaciones.add(e11_12);
		caminosEntreEstaciones.add(e12_13);
		caminosEntreEstaciones.add(e13_14);
		caminosEntreEstaciones.add(e9_14);
		caminosEntreEstaciones.add(e14_15);
		caminosEntreEstaciones.add(e9_10);
		caminosEntreEstaciones.add(e7_8);
		caminosEntreEstaciones.add(e8_9);
		
		//directos
		caminosEntreEstaciones.add(e1_2inv);
		caminosEntreEstaciones.add(e2_3inv);
		caminosEntreEstaciones.add(e3_7inv);
		caminosEntreEstaciones.add(e7_4inv);
		caminosEntreEstaciones.add(e4_5inv);
		caminosEntreEstaciones.add(e5_6inv);
		caminosEntreEstaciones.add(e2_11inv);
		caminosEntreEstaciones.add(e11_12inv);
		caminosEntreEstaciones.add(e12_13inv);
		caminosEntreEstaciones.add(e13_14inv);
		caminosEntreEstaciones.add(e9_14inv);
		caminosEntreEstaciones.add(e14_15inv);
		caminosEntreEstaciones.add(e9_10inv);
		caminosEntreEstaciones.add(e7_8inv);
		caminosEntreEstaciones.add(e8_9inv);

		RutaGeneral rutaGeneral = new RutaGeneral(estaciones, caminosEntreEstaciones);
		Dijkstra dijkstra = new Dijkstra(rutaGeneral);
        dijkstra.execute(estaciones.get(9));
        LinkedList<Estacion> path = dijkstra.getPath(estaciones.get(0));
        System.out.println(path);
        //administradorDeRutas.guardar(rutaGeneral);
	}
	
	@Test
	public void dijkstraTest2() {
		RutaGeneral rutaGeneral = rutaGeneralDAO.obtenerRutaGeneral();
		Dijkstra dijkstra = new Dijkstra(rutaGeneral);
        dijkstra.execute(rutaGeneral.getVertexes().get(9));
        LinkedList<Estacion> path = dijkstra.getPath(rutaGeneral.getVertexes().get(0));
        System.out.println(path);
	}*/

}
