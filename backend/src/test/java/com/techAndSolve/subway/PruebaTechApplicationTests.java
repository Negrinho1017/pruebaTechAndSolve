package com.techAndSolve.subway;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.techAndSolve.subway.dominio.Edge;
import com.techAndSolve.subway.dominio.Graph;
import com.techAndSolve.subway.dominio.Vertex;
import com.techAndSolve.subway.servicio.AdministradorDeRutas;
import com.techAndSolve.subway.util.Dijkstra;

@SpringBootTest(classes = SubwayApplication.class)
@RunWith(SpringRunner.class)
public class PruebaTechApplicationTests {
	
	@Autowired
	AdministradorDeRutas administradorDeRutas;
	@Test
	public void contextLoads() {
		administradorDeRutas.probar();
	}
	
	@Test
	public void dijkstraTest() {
		Vertex v1 = new Vertex("1","1");
		Vertex v2 = new Vertex("2","2");
		Vertex v3 = new Vertex("3","3");
		Vertex v4 = new Vertex("4","4");
		Vertex v5 = new Vertex("5","5");
		Vertex v6 = new Vertex("6","6");
		Vertex v7 = new Vertex("7","7");
		Vertex v8 = new Vertex("8","8");
		Vertex v9 = new Vertex("9","9");
		Vertex v10 = new Vertex("10","10");
		Vertex v11 = new Vertex("11","11");
		Vertex v12 = new Vertex("12","12");
		Vertex v13 = new Vertex("13","13");
		Vertex v14 = new Vertex("14","14");
		Vertex v15 = new Vertex("15","15");
		List<Vertex> vertices = new ArrayList<>();
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);
		vertices.add(v5);
		vertices.add(v6);
		vertices.add(v7);
		vertices.add(v8);
		vertices.add(v9);
		vertices.add(v10);
		vertices.add(v11);
		vertices.add(v12);
		vertices.add(v13);
		vertices.add(v14);
		vertices.add(v15);
		//Directos
		Edge e1_2 = new Edge("1_2", v1, v2, 4);
		Edge e2_3 = new Edge("2_3", v2, v3, 4);
		Edge e3_7 = new Edge("3_7", v3, v7, 4);
		Edge e7_4 = new Edge("7_4", v7, v4, 4);
		Edge e4_5 = new Edge("4_5", v4, v5, 4);
		Edge e5_6 = new Edge("5_6", v5, v6, 4);
		Edge e2_11 = new Edge("2_11", v2, v11, 4);
		Edge e11_12 = new Edge("11_12", v11, v12, 4);
		Edge e12_13 = new Edge("12_13", v12, v13, 4);
		Edge e13_14 = new Edge("13_14", v13, v14, 4);
		Edge e9_14 = new Edge("9_14", v9, v14, 4);
		Edge e14_15 = new Edge("14_15", v14, v15, 4);
		Edge e9_10 = new Edge("9_10", v9, v10, 4);
		Edge e7_8 = new Edge("7_8", v7, v8, 4);
		Edge e8_9 = new Edge("8_9", v8, v9, 4);

		//Inversos
		Edge e1_2inv = new Edge("1_2", v2, v1, 4);
		Edge e2_3inv = new Edge("2_3", v3, v2, 4);
		Edge e3_7inv = new Edge("3_7", v7, v3, 4);
		Edge e7_4inv = new Edge("7_4", v4, v7, 4);
		Edge e4_5inv = new Edge("4_5", v5, v4, 4);
		Edge e5_6inv = new Edge("5_6", v6, v5, 4);
		Edge e2_11inv = new Edge("2_11", v11, v2, 4);
		Edge e11_12inv = new Edge("11_12", v12, v11, 4);
		Edge e12_13inv = new Edge("12_13", v13, v12, 4);
		Edge e13_14inv = new Edge("13_14", v14, v13, 4);
		Edge e9_14inv = new Edge("9_14", v14, v9, 4);
		Edge e14_15inv = new Edge("14_15", v15, v14, 4);
		Edge e9_10inv = new Edge("9_10", v10, v9, 4);
		Edge e7_8inv = new Edge("7_8", v8, v7, 4);
		Edge e8_9inv = new Edge("8_9", v9, v8, 4);
		
		List<Edge> aristas = new ArrayList<>();
		
		//directos
		aristas.add(e1_2);
		aristas.add(e2_3);
		aristas.add(e3_7);
		aristas.add(e7_4);
		aristas.add(e4_5);
		aristas.add(e5_6);
		aristas.add(e2_11);
		aristas.add(e11_12);
		aristas.add(e12_13);
		aristas.add(e13_14);
		aristas.add(e9_14);
		aristas.add(e14_15);
		aristas.add(e9_10);
		aristas.add(e7_8);
		aristas.add(e8_9);
		
		//directos
		aristas.add(e1_2inv);
		aristas.add(e2_3inv);
		aristas.add(e3_7inv);
		aristas.add(e7_4inv);
		aristas.add(e4_5inv);
		aristas.add(e5_6inv);
		aristas.add(e2_11inv);
		aristas.add(e11_12inv);
		aristas.add(e12_13inv);
		aristas.add(e13_14inv);
		aristas.add(e9_14inv);
		aristas.add(e14_15inv);
		aristas.add(e9_10inv);
		aristas.add(e7_8inv);
		aristas.add(e8_9inv);

		Graph grafo = new Graph(vertices, aristas);
		Dijkstra dijkstra = new Dijkstra(grafo);
        dijkstra.execute(vertices.get(9));
        LinkedList<Vertex> path = dijkstra.getPath(vertices.get(0));
        System.out.println(path);
	}

}
