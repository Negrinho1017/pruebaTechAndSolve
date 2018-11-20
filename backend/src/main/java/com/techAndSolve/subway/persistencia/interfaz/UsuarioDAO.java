package com.techAndSolve.subway.persistencia.interfaz;

public interface UsuarioDAO {
	public boolean existeElUsuario(String idUsuario);
	
	public int obtenerRolDelUsuario(String idUsuario);
}
