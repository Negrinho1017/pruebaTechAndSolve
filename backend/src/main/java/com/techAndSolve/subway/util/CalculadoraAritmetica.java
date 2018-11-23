package com.techAndSolve.subway.util;

import java.util.List;

import com.techAndSolve.subway.dominio.SubRuta;

public class CalculadoraAritmetica {
	public static int calcularTiempoTotalParaUnaRuta(List<SubRuta> subRutas, int tiempo) {
		return 2 * subRutas.size() + tiempo - 2;
	}
}
