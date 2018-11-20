package com.techAndSolve.subway.dominio.excepcion;

public class SubwayException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public SubwayException(String message) {
		super(message);
	}
}
