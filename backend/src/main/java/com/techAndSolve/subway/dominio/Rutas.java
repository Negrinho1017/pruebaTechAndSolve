package com.techAndSolve.subway.dominio;

import java.util.List;

public class Rutas {
	List<Integer> RutaA;
	List<Integer> RutaB;
	List<Integer> RutaC;
	List<Integer> RutaD;
	List<Integer> RutaE;
	List<Integer> RutaF;
	
	public Rutas() {}
	public Rutas(List<Integer> rutaA, List<Integer> rutaB, List<Integer> rutaC, List<Integer> rutaD,
			List<Integer> rutaE, List<Integer> rutaF) {
		super();
		RutaA = rutaA;
		RutaB = rutaB;
		RutaC = rutaC;
		RutaD = rutaD;
		RutaE = rutaE;
		RutaF = rutaF;
	}
	
	public List<Integer> getRutaA() {
		return RutaA;
	}
	public List<Integer> getRutaB() {
		return RutaB;
	}
	public List<Integer> getRutaC() {
		return RutaC;
	}
	public List<Integer> getRutaD() {
		return RutaD;
	}
	public List<Integer> getRutaE() {
		return RutaE;
	}
	public List<Integer> getRutaF() {
		return RutaF;
	}
	
}
