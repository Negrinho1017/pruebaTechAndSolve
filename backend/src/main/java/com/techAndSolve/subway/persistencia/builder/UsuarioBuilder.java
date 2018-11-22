package com.techAndSolve.subway.persistencia.builder;

import java.util.List;

import com.techAndSolve.subway.dominio.Respuesta;
import com.techAndSolve.subway.dominio.Usuario;
import com.techAndSolve.subway.persistencia.entidad.RespuestaEntidad;
import com.techAndSolve.subway.persistencia.entidad.UsuarioEntidad;

public class UsuarioBuilder {
	
	public static Usuario convertirDeEntidadADominio(UsuarioEntidad usuarioEntidad) {
		int rol = usuarioEntidad.getRol();
		List<Respuesta> respuestasObtenidas = RespuestaBuilder.convertirListaDeEntidadADominio(
				usuarioEntidad.getRespuestasObtenidas());
		String identificacion = usuarioEntidad.getIdentificacion();
		String nombreUsuario = usuarioEntidad.getNombreUsuario();
		return new Usuario(rol, respuestasObtenidas, identificacion, nombreUsuario);
	}
	
	public static UsuarioEntidad convertirDeDominioAEntidad(Usuario usuario) {
		int rol = usuario.getRol();
		List<RespuestaEntidad> respuestasObtenidas = RespuestaBuilder.convertirListaDeDominioAEntidad(
				usuario.getRespuestasObtenidas());
		String identificacion = usuario.getIdentificacion();
		String nombreUsuario = usuario.getNombreUsuario();
		return new UsuarioEntidad(rol, respuestasObtenidas, identificacion, nombreUsuario);
	}
}
