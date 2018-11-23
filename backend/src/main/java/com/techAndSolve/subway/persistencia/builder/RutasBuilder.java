package com.techAndSolve.subway.persistencia.builder;

import java.util.List;

import com.techAndSolve.subway.dominio.Rutas;
import com.techAndSolve.subway.persistencia.entidad.RutasEntidad;

public class RutasBuilder {
	public static Rutas convertirDeEntidadADominio(RutasEntidad rutasEntidad) {
		List<Integer> rutaA = rutasEntidad.getRutaA();
		List<Integer> rutaB = rutasEntidad.getRutaB();
		List<Integer> rutaC = rutasEntidad.getRutaC();
		List<Integer> rutaD = rutasEntidad.getRutaD();
		List<Integer> rutaE = rutasEntidad.getRutaE();
		List<Integer> rutaF = rutasEntidad.getRutaF();
		return new Rutas(rutaA, rutaB, rutaC, rutaD, rutaE, rutaF);
	}
}
