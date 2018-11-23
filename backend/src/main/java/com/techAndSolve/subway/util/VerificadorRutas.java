package com.techAndSolve.subway.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.techAndSolve.subway.dominio.Estacion;
import com.techAndSolve.subway.dominio.Rutas;
import com.techAndSolve.subway.dominio.SubRuta;

public class VerificadorRutas {
	private static final String RUTA_F = "F";
	private static final String RUTA_E = "E";
	private static final String RUTA_D = "D";
	private static final String RUTA_C = "C";
	private static final String RUTA_B = "B";
	private static final String RUTA_A = "A";
	private static String nombreSubruta;
	public static List<SubRuta> devolverRutasASeguir(List<Estacion> estaciones, Rutas rutas){
		List<String> idsEstacion = new ArrayList<>();
		for(Estacion estacion : estaciones) {
			idsEstacion.add(estacion.getId());
		}
		List<Integer> numerosEstacion = ListUtil.convertirListaStringAEntero(idsEstacion);
		List<SubRuta> subRutas = new ArrayList<>();
		return verificarMejorRuta(numerosEstacion, rutas, subRutas);
	}
	
	public static List<SubRuta> verificarMejorRuta(List<Integer> numerosEstacion, Rutas rutas,
			List<SubRuta> subRutas ) {
		List<Integer> estaciones = calcularEstacionesCubiertas(numerosEstacion, rutas);
		SubRuta subRuta = new SubRuta(nombreSubruta,estaciones.get(0), estaciones.get(estaciones.size()-1));
		subRutas.add(subRuta);
		ListUtil.eliminarSubLista(numerosEstacion, estaciones);
		if(numerosEstacion.size()>0) {
			numerosEstacion.add(0, subRuta.getEstacionDestino());
		}
		return (numerosEstacion.size()!=0) ? verificarMejorRuta(numerosEstacion, rutas, subRutas) : subRutas;
	}

	public static List<Integer> calcularEstacionesCubiertas(List<Integer> numerosEstacion, Rutas rutas) {
		int estacionesCubiertas = 0;
		List<Integer> estaciones = new ArrayList<>();
		if(calculadorEstacionesCubiertas(numerosEstacion, rutas.getRutaA()).size() > estacionesCubiertas) {
			estacionesCubiertas = calculadorEstacionesCubiertas(numerosEstacion, rutas.getRutaA()).size();
			estaciones = calculadorEstacionesCubiertas(numerosEstacion, rutas.getRutaA());
			nombreSubruta = RUTA_A;
		}
		if(calculadorEstacionesCubiertas(numerosEstacion, rutas.getRutaB()).size() > estacionesCubiertas) {
			estacionesCubiertas = calculadorEstacionesCubiertas(numerosEstacion, rutas.getRutaB()).size();
			estaciones = calculadorEstacionesCubiertas(numerosEstacion, rutas.getRutaB());
			nombreSubruta = RUTA_B;
		}
		if(calculadorEstacionesCubiertas(numerosEstacion, rutas.getRutaC()).size() > estacionesCubiertas) {
			estacionesCubiertas = calculadorEstacionesCubiertas(numerosEstacion, rutas.getRutaC()).size();
			estaciones = calculadorEstacionesCubiertas(numerosEstacion, rutas.getRutaC());
			nombreSubruta = RUTA_C;
		}
		if(calculadorEstacionesCubiertas(numerosEstacion, rutas.getRutaD()).size() > estacionesCubiertas) {
			estacionesCubiertas = calculadorEstacionesCubiertas(numerosEstacion, rutas.getRutaD()).size();
			estaciones = calculadorEstacionesCubiertas(numerosEstacion, rutas.getRutaD());
			nombreSubruta = RUTA_D;
		}
		if(calculadorEstacionesCubiertas(numerosEstacion, rutas.getRutaE()).size() > estacionesCubiertas) {
			estacionesCubiertas = calculadorEstacionesCubiertas(numerosEstacion, rutas.getRutaE()).size();
			estaciones = calculadorEstacionesCubiertas(numerosEstacion, rutas.getRutaE());
			nombreSubruta = RUTA_E;
		}
		if(calculadorEstacionesCubiertas(numerosEstacion, rutas.getRutaF()).size() > estacionesCubiertas) {
			estacionesCubiertas = calculadorEstacionesCubiertas(numerosEstacion, rutas.getRutaF()).size();
			estaciones = calculadorEstacionesCubiertas(numerosEstacion, rutas.getRutaF());
			nombreSubruta = RUTA_F;
		}
		return estaciones;
	}
	
	public static List<Integer> calculadorEstacionesCubiertas(List<Integer> numerosEstacion, List<Integer> ruta) {
		List<Integer> estaciones = new ArrayList<>(numerosEstacion);
		boolean estaEnLaMismaRuta = false;
		int posicionFinal = estaciones.size()-1;
		while(!estaEnLaMismaRuta) {
			if(Collections.indexOfSubList(ruta , estaciones) != -1) {
				estaEnLaMismaRuta = true;
			}else {
				estaciones.remove(posicionFinal);
				posicionFinal--;
			}
		}
		if(estaciones.size()==1) {
			Collections.reverse(ruta);
			estaEnLaMismaRuta = false;
			estaciones = new ArrayList<>(numerosEstacion);
			posicionFinal = estaciones.size()-1;
			while(!estaEnLaMismaRuta) {		
				if(Collections.indexOfSubList(ruta , estaciones) != -1) {
					estaEnLaMismaRuta = true;
				}else {
					estaciones.remove(posicionFinal);
					posicionFinal--;
				}
			}
		}
		return estaciones;
	}
}
