package com.techAndSolve.subway.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techAndSolve.subway.dominio.Consulta;
import com.techAndSolve.subway.dominio.Respuesta;
import com.techAndSolve.subway.dominio.Usuario;
import com.techAndSolve.subway.dominio.excepcion.SubwayException;
import com.techAndSolve.subway.persistencia.interfaz.ConsultasYRespuestasDAO;
import com.techAndSolve.subway.persistencia.interfaz.RutaGeneralDAO;
import com.techAndSolve.subway.persistencia.interfaz.UsuarioDAO;
import com.techAndSolve.subway.util.CalculadoraAritmetica;

public class AdministradorDatosUsuario {
	
	private static final String USUARIO_NO_ENCONTRADO = "Usuario no encontrado";

	@Autowired
	RutaGeneralDAO rutaGeneralDAO;
	
	@Autowired
	ConsultasYRespuestasDAO consultasYRespuestasDAO;
	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Autowired
	AdministradorRutas administradorRutas;
	
	public void crearRespuesta(String idUsuario, Consulta consulta) {
		int tiempo = CalculadoraAritmetica.calcularTiempoTotalParaUnaRuta(
				administradorRutas.obtenerListadoDeRutasASeguir(consulta), administradorRutas.obtenerTiempo(consulta));
		Respuesta respuesta = new Respuesta(tiempo, consulta,
				new ArrayList<>(administradorRutas.obtenerRutaMasCercana(consulta)));
		if(existeElUsuario(idUsuario)) {
			consultasYRespuestasDAO.actualizarRespuestasUsuario(respuesta, idUsuario);
		}else {
			consultasYRespuestasDAO.crearRespuesta(respuesta, idUsuario);
		}	
	}
	
	public boolean existeElUsuario(String idUsuario) {
		return usuarioDAO.existeElUsuario(idUsuario);
	}
	
	public boolean datosIngresadosCorrectamente(String idUsuario, String nombreUsuario) {
		return usuarioDAO.datosIngresadosCorrectamente(idUsuario, nombreUsuario);
	}
	
	public Usuario hayInicioDeSesion(String idUsuario, String nombreUsuario) {
		if(existeElUsuario(idUsuario) && !datosIngresadosCorrectamente(idUsuario, nombreUsuario)) {
			throw new SubwayException("Datos ingresados incorrectamente");
		}
		if(!existeElUsuario(idUsuario)){
			usuarioDAO.crearUsuario(idUsuario, nombreUsuario);	
		}
		return usuarioDAO.obtenerUsuarioPorId(idUsuario);
	}
	
	public List<Respuesta> obtenerRespuestasEntregadasPorElUsuario(String idUsuario){
		if(!existeElUsuario(idUsuario)) {
			throw new SubwayException(USUARIO_NO_ENCONTRADO);
		}
		return consultasYRespuestasDAO.obtenerRespuestasPorUsuario(idUsuario);
	}
	
	public int obtenerRolDelUsuario(String idUsuario) {
		return usuarioDAO.obtenerRolDelUsuario(idUsuario);
	}
}
