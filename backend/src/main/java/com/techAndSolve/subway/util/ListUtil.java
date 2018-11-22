package com.techAndSolve.subway.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
	public static List<Integer> convertirListaStringAEntero(List<String> listaString){
		List<Integer> enteros = new ArrayList<>();
		for(String string: listaString) {
			enteros.add(Integer.parseInt(string));
		}
		return enteros;
	}
	
	public static List<Integer> eliminarSubLista(List<Integer> listaOriginal, List<Integer> listaEliminar) {
		int i = 0;
		while(i < listaEliminar.size()) {
			listaOriginal.remove(0);
			i++;
		}
		return listaOriginal;
	}
}
