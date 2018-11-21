package com.techAndSolve.subway.persistencia.interfaz;

import com.techAndSolve.subway.dominio.Usuario;

public interface UsuarioDAO {
	public boolean existeElUsuario(String idUsuario);
	
	public int obtenerRolDelUsuario(String idUsuario);
	
	public boolean datosIngresadosCorrectamente(String idUsuario, String nombreUsuario);
	
	public Usuario obtenerUsuarioPorId(String idUsuario);
	
	public void crearUsuario(String idUsuario, String nombreUsuario);
}
