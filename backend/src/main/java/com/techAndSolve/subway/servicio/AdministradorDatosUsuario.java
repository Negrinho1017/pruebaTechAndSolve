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
	/*@Autowired
	MongoOperations mongoOperations;
	
	private static final String RUTAS = "rutas";
	
	public AdministradorRutas(MongoOperations mongoOperations) {
		super();
		this.mongoOperations = mongoOperations;
	}
	
	public void probar() {
		Query pruebaPorId = query(where("idRutas").is(1));
		Rutas rutas = mongoOperations.find(pruebaPorId, Rutas.class, RUTAS).get(0);
		System.out.println(rutas.getRutaA().get(1));
		System.out.println(rutas.getRutaB().get(4));
		System.out.println(rutas.getRutaC().get(6));
		System.out.println(rutas.getRutaD().get(3));
		System.out.println(rutas.getRutaE().get(5));
		System.out.println(rutas.getRutaF().get(7));
	}
	
	public void guardar(RutaGeneral graph) {
		mongoOperations.save(graph, "rutaGeneral");
	}*/
	
	public void crearRespuesta(String idUsuario, Consulta consulta) {
		Respuesta respuesta = new Respuesta(administradorRutas.obtenerTiempo(consulta),
				consulta, new ArrayList<>(administradorRutas.obtenerRutaMasCercana(consulta)));
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
