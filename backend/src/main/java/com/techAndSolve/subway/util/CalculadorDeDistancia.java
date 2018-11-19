package com.techAndSolve.subway.util;

import java.util.List;

import com.techAndSolve.subway.dominio.Consulta;
import com.techAndSolve.subway.dominio.Rutas;

public class CalculadorDeDistancia {
	public static int calcularTiempoEntre2Puntos(Consulta consulta, Rutas rutas) {
		int tiempo = 0;
		tiempo = calcularMenorTiempoSiEstanEnLaMismaRuta(consulta, rutas);
		return tiempo;
	}
	
	public static int calcularTiempoSiNoEstanEnLaMismaRuta(Consulta consulta, Rutas rutas) {
		int tiempoActual = 0;
		if(estaEnLaRuta(consulta.getEstacionOrigen(),rutas.getRutaA())) {
			
		}
		return 0;
	}

	public static int calcularMenorTiempoSiEstanEnLaMismaRuta(Consulta consulta, Rutas rutas) {
		int tiempoActual = 0;
		if(estanEnLaMismaRuta(consulta,rutas.getRutaA())) {
			tiempoActual = calcularTiempoSiEstanEnLaMismaRuta(consulta, rutas.getRutaA());
		}
		if(estanEnLaMismaRuta(consulta,rutas.getRutaB())) {
			if(calcularTiempoSiEstanEnLaMismaRuta(consulta, rutas.getRutaB())<tiempoActual
					&& tiempoActual != 0) {
				tiempoActual = calcularTiempoSiEstanEnLaMismaRuta(consulta, rutas.getRutaB());
			}
		}
		if(estanEnLaMismaRuta(consulta,rutas.getRutaC())) {
			if(calcularTiempoSiEstanEnLaMismaRuta(consulta, rutas.getRutaC())<tiempoActual
					&& tiempoActual != 0) {
				tiempoActual = calcularTiempoSiEstanEnLaMismaRuta(consulta, rutas.getRutaC());
			}
		}
		if(estanEnLaMismaRuta(consulta,rutas.getRutaD())) {
			if(calcularTiempoSiEstanEnLaMismaRuta(consulta, rutas.getRutaD())<tiempoActual
					&& tiempoActual != 0) {
				tiempoActual = calcularTiempoSiEstanEnLaMismaRuta(consulta, rutas.getRutaD());
			}
		}
		if(estanEnLaMismaRuta(consulta,rutas.getRutaE())) {
			if(calcularTiempoSiEstanEnLaMismaRuta(consulta, rutas.getRutaE())<tiempoActual
					&& tiempoActual != 0) {
				tiempoActual = calcularTiempoSiEstanEnLaMismaRuta(consulta, rutas.getRutaE());
			}
		}
		if(estanEnLaMismaRuta(consulta,rutas.getRutaF())) {
			if(calcularTiempoSiEstanEnLaMismaRuta(consulta, rutas.getRutaF())<tiempoActual
					&& tiempoActual != 0) {
				tiempoActual = calcularTiempoSiEstanEnLaMismaRuta(consulta, rutas.getRutaF());
			}
		}
		return tiempoActual;
	}

	public static int calcularTiempoSiEstanEnLaMismaRuta(Consulta consulta, List<Integer> ruta) {
		int tiempo = 0;
		int contabilizadorEstaciones = 0;
		for(int i = 0;i<ruta.size();i++) {
			if(ruta.get(i)==consulta.getEstacionOrigen()
					|| ruta.get(i)==consulta.getEstacionDestino()) {
				contabilizadorEstaciones++;
			}
			if(contabilizadorEstaciones==1) {
				tiempo+=4;
			}
			if(contabilizadorEstaciones==2) {
				break;
			}
		}
		return tiempo;
	}
	
	public static boolean estanEnLaMismaRuta(Consulta consulta, List<Integer> ruta) {
		return (ruta.contains(consulta.getEstacionOrigen())&& ruta.contains(consulta.getEstacionDestino()))
				? true : false;
	}
	
	public static boolean estaEnLaRuta(int estacion, List<Integer> ruta) {
		return (ruta.contains(estacion)) ? true : false;
	}
}
