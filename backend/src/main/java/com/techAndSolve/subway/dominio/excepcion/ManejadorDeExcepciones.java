package com.techAndSolve.subway.dominio.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManejadorDeExcepciones {
	
	@ExceptionHandler(SubwayException.class)
	public ResponseEntity<RespuestaError> manejarExcepcion(SubwayException ex) {
		RespuestaError response = new RespuestaError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<RespuestaError> manejarExcepcionGeneral(Throwable ex) {
		RespuestaError response = new RespuestaError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Ha ocurrido un error en la aplicación");
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
