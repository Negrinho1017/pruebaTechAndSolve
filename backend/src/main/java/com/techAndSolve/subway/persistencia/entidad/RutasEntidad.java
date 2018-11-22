package com.techAndSolve.subway.persistencia.entidad;

import java.util.List;

public class RutasEntidad {
	List<Integer> RutaA;
	List<Integer> RutaB;
	List<Integer> RutaC;
	List<Integer> RutaD;
	List<Integer> RutaE;
	List<Integer> RutaF;
	
	public RutasEntidad(List<Integer> rutaA, List<Integer> rutaB, List<Integer> rutaC, List<Integer> rutaD,
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
	public void setRutaA(List<Integer> rutaA) {
		RutaA = rutaA;
	}
	public List<Integer> getRutaB() {
		return RutaB;
	}
	public void setRutaB(List<Integer> rutaB) {
		RutaB = rutaB;
	}
	public List<Integer> getRutaC() {
		return RutaC;
	}
	public void setRutaC(List<Integer> rutaC) {
		RutaC = rutaC;
	}
	public List<Integer> getRutaD() {
		return RutaD;
	}
	public void setRutaD(List<Integer> rutaD) {
		RutaD = rutaD;
	}
	public List<Integer> getRutaE() {
		return RutaE;
	}
	public void setRutaE(List<Integer> rutaE) {
		RutaE = rutaE;
	}
	public List<Integer> getRutaF() {
		return RutaF;
	}
	public void setRutaF(List<Integer> rutaF) {
		RutaF = rutaF;
	}
}
