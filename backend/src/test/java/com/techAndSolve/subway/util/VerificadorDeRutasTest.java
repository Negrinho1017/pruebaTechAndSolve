package com.techAndSolve.subway.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.techAndSolve.subway.dominio.Estacion;
import com.techAndSolve.subway.dominio.Rutas;
import com.techAndSolve.subway.dominio.SubRuta;

public class VerificadorDeRutasTest {
	
	List<Integer> rutaA;
	List<Integer> rutaB;
	List<Integer> rutaC;
	List<Integer> rutaD;
	List<Integer> rutaE;
	List<Integer> rutaF;
	List<Integer> numerosEstacion;
	List<Estacion> estaciones;
	List<Integer> listaFinal;
	Rutas rutas;
	
	@Before
	public void setUp() {
		rutaA = new ArrayList<>();
		rutaB = new ArrayList<>();
		rutaC = new ArrayList<>();
		rutaD = new ArrayList<>();
		rutaE = new ArrayList<>();
		rutaF = new ArrayList<>();
		numerosEstacion = new ArrayList<>();
		rutaA.add(6);
		rutaA.add(5);
		rutaA.add(4);
		rutaA.add(7);
		rutaA.add(8);
		rutaA.add(9);
		rutaA.add(14);
		rutaA.add(15);
		rutaB.add(6);
		rutaB.add(4);
		rutaB.add(8);
		rutaB.add(9);
		numerosEstacion.add(6);
		numerosEstacion.add(4);
		numerosEstacion.add(8);
		numerosEstacion.add(14);
		numerosEstacion.add(15);
		estaciones = new ArrayList<>();
		rutas = new Rutas(rutaA, rutaB, rutaC, rutaD, rutaE, rutaF);
	}
	
	@Test
	public void calculadorEstacionesCubiertasTest() {	
		List<Integer> listaFinal = VerificadorRutas.calculadorEstacionesCubiertas(numerosEstacion, rutaB);
		assertEquals(3, listaFinal.size());
		assertEquals(6, Integer.parseInt(listaFinal.get(0).toString()));
		assertEquals(4, Integer.parseInt(listaFinal.get(1).toString()));
		assertEquals(8, Integer.parseInt(listaFinal.get(2).toString()));
	}
	
	@Test
	public void calcularEstacionesCubiertasTest() {	
		List<Integer> listaFinal = VerificadorRutas.calcularEstacionesCubiertas(numerosEstacion, rutas);
		assertEquals(3, listaFinal.size());
		assertEquals(6, Integer.parseInt(listaFinal.get(0).toString()));
		assertEquals(4, Integer.parseInt(listaFinal.get(1).toString()));
		assertEquals(8, Integer.parseInt(listaFinal.get(2).toString()));
	}
	
	@Test
	public void calculadorEstacionesCubiertasTestReversa() {	
		List<Integer> numerosEstacion = new ArrayList<>();
		numerosEstacion.add(3);
		numerosEstacion.add(2);
		numerosEstacion.add(1);
		rutaC.add(1);
		rutaC.add(2);
		rutaC.add(3);
		List<Integer> listaFinal = VerificadorRutas.calcularEstacionesCubiertas(numerosEstacion, rutas);
		assertEquals(3, listaFinal.size());
		assertEquals(3, Integer.parseInt(listaFinal.get(0).toString()));
		assertEquals(2, Integer.parseInt(listaFinal.get(1).toString()));
		assertEquals(1, Integer.parseInt(listaFinal.get(2).toString()));
	}
	
	@Test
	public void verificarMejorRutaTest() {	
		List<SubRuta> subRutas = new ArrayList<>();
		List<SubRuta> subRutasTotales = VerificadorRutas.verificarMejorRuta(numerosEstacion, rutas, subRutas);
		assertEquals(2,subRutasTotales.size());
		assertEquals(6,subRutasTotales.get(0).getEstacionOrigen());
		assertEquals(8,subRutasTotales.get(0).getEstacionDestino());
		assertEquals(14,subRutasTotales.get(1).getEstacionOrigen());
		assertEquals(15,subRutasTotales.get(1).getEstacionDestino());
	}
	
	@Test
	public void devolverRutasASeguirEnOrden() {	
		Estacion estacion6 = new Estacion("6","6");
		Estacion estacion4 = new Estacion("4","4");
		Estacion estacion8 = new Estacion("8","8");
		Estacion estacion14 = new Estacion("14","14");
		Estacion estacion15 = new Estacion("15","15");
		estaciones.add(estacion6);
		estaciones.add(estacion4);
		estaciones.add(estacion8);
		estaciones.add(estacion14);
		estaciones.add(estacion15);
		List<SubRuta> subRutasTotales = VerificadorRutas.devolverRutasASeguir(estaciones, rutas);
		assertEquals(2,subRutasTotales.size());
		assertEquals(6,subRutasTotales.get(0).getEstacionOrigen());
		assertEquals(8,subRutasTotales.get(0).getEstacionDestino());
		assertEquals(14,subRutasTotales.get(1).getEstacionOrigen());
		assertEquals(15,subRutasTotales.get(1).getEstacionDestino());
	}
	
	@Test
	public void devolverRutasASeguirOrde() {	
		Estacion estacion6 = new Estacion("6","6");
		Estacion estacion4 = new Estacion("4","4");
		Estacion estacion8 = new Estacion("8","8");
		Estacion estacion14 = new Estacion("15","15");
		Estacion estacion15 = new Estacion("14","14");
		estaciones.add(estacion6);
		estaciones.add(estacion4);
		estaciones.add(estacion8);
		estaciones.add(estacion14);
		estaciones.add(estacion15);
		List<SubRuta> subRutasTotales = VerificadorRutas.devolverRutasASeguir(estaciones, rutas);
		assertEquals(2,subRutasTotales.size());
		assertEquals(6,subRutasTotales.get(0).getEstacionOrigen());
		assertEquals(8,subRutasTotales.get(0).getEstacionDestino());
		assertEquals(15,subRutasTotales.get(1).getEstacionOrigen());
		assertEquals(14,subRutasTotales.get(1).getEstacionDestino());
	}
}
