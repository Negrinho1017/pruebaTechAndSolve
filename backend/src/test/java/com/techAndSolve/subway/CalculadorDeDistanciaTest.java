package com.techAndSolve.subway;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.techAndSolve.subway.dominio.Consulta;
import com.techAndSolve.subway.dominio.Rutas;
import com.techAndSolve.subway.util.CalculadorDeDistancia;

public class CalculadorDeDistanciaTest {
	@Test
	public void verificarSiEstanEnLaMismaRutaYEsVerdad() {
		List<Integer> ruta = new ArrayList<>();
		ruta.add(6);
		ruta.add(5);
		ruta.add(4);
		ruta.add(7);
		ruta.add(8);
		ruta.add(9);
		ruta.add(14);
		ruta.add(15);
		assertTrue(CalculadorDeDistancia.estanEnLaMismaRuta(new Consulta(7, 14),ruta));
	}
	
	@Test
	public void verificarSiEstanEnLaMismaRutaYNoEsVerdad() {
		List<Integer> ruta = new ArrayList<>();
		ruta.add(6);
		ruta.add(5);
		ruta.add(4);
		ruta.add(7);
		ruta.add(8);
		ruta.add(9);
		ruta.add(14);
		ruta.add(15);
		assertFalse(CalculadorDeDistancia.estanEnLaMismaRuta(new Consulta(7, 1),ruta));
	}
	
	@Test
	public void verificarSiEstanEnLaMismaRutaYEsVerdadEnDesorden() {
		List<Integer> ruta = new ArrayList<>();
		ruta.add(6);
		ruta.add(5);
		ruta.add(4);
		ruta.add(7);
		ruta.add(8);
		ruta.add(9);
		ruta.add(14);
		ruta.add(15);
		assertTrue(CalculadorDeDistancia.estanEnLaMismaRuta(new Consulta(7, 6),ruta));
	}
	
	@Test
	public void calcularTiempoSiEstanEnLaMismaRuta() {
		List<Integer> ruta = new ArrayList<>();
		ruta.add(6);
		ruta.add(5);
		ruta.add(4);
		ruta.add(7);
		ruta.add(8);
		ruta.add(9);
		ruta.add(14);
		ruta.add(15);
		Rutas rutas = new Rutas(ruta,null,null,null,null,null);
		assertEquals(12, CalculadorDeDistancia.calcularTiempoSiEstanEnLaMismaRuta(new Consulta(6,7), rutas.getRutaA()));
	}
	
	@Test
	public void calcularTiempoSiEstanEnLaMismaRutaEnDesorden() {
		List<Integer> ruta = new ArrayList<>();
		ruta.add(6);
		ruta.add(5);
		ruta.add(4);
		ruta.add(7);
		ruta.add(8);
		ruta.add(9);
		ruta.add(14);
		ruta.add(15);
		Rutas rutas = new Rutas(ruta,null,null,null,null,null);
		assertEquals(20, CalculadorDeDistancia.calcularTiempoSiEstanEnLaMismaRuta(new Consulta(15,4), rutas.getRutaA()));
	}
	
	@Test
	public void calcularMenorTiempoSiEstanEnLaMismaRuta() {
		List<Integer> rutaA = new ArrayList<>();
		rutaA.add(6);
		rutaA.add(5);
		rutaA.add(4);
		rutaA.add(7);
		rutaA.add(8);
		rutaA.add(9);
		rutaA.add(14);
		rutaA.add(15);
		List<Integer> rutaB = new ArrayList<>();
		rutaB.add(7);
		rutaB.add(8);
		rutaB.add(5);
		rutaB.add(9);
		rutaB.add(15);
		List<Integer> rutaC = new ArrayList<>();
		List<Integer> rutaD = new ArrayList<>();
		List<Integer> rutaE = new ArrayList<>();
		List<Integer> rutaF = new ArrayList<>();
		Rutas rutas = new Rutas(rutaA,rutaB,rutaC,rutaD,rutaE,rutaF);
		assertEquals(8, CalculadorDeDistancia.calcularMenorTiempoSiEstanEnLaMismaRuta
				(new Consulta(5,15), rutas));
	}
	
	@Test
	public void verificarSiLaEstacionEstaEnLaRuta() {
		List<Integer> ruta = new ArrayList<>();
		ruta.add(6);
		ruta.add(5);
		ruta.add(4);
		ruta.add(7);
		ruta.add(8);
		ruta.add(9);
		ruta.add(14);
		ruta.add(15);
		assertTrue(CalculadorDeDistancia.estaEnLaRuta(7,ruta));
	}
	
	@Test
	public void verificarSiLaEstacionNoEstaEnLaRuta() {
		List<Integer> ruta = new ArrayList<>();
		ruta.add(6);
		ruta.add(5);
		ruta.add(4);
		ruta.add(7);
		ruta.add(8);
		ruta.add(9);
		ruta.add(14);
		ruta.add(15);
		assertFalse(CalculadorDeDistancia.estaEnLaRuta(1,ruta));
	}
}
