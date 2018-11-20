package com.techAndSolve.subway.servicio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techAndSolve.subway.dominio.Consulta;
import com.techAndSolve.subway.dominio.Estacion;
import com.techAndSolve.subway.dominio.Respuesta;
import com.techAndSolve.subway.dominio.RutaGeneral;
import com.techAndSolve.subway.persistencia.interfaz.ConsultasYRespuestasDAO;
import com.techAndSolve.subway.persistencia.interfaz.RutaGeneralDAO;
import com.techAndSolve.subway.persistencia.interfaz.UsuarioDAO;
import com.techAndSolve.subway.util.Dijkstra;

public class AdministradorDeRutas {
	
	@Autowired
	RutaGeneralDAO rutaGeneralDAO;
	
	@Autowired
	ConsultasYRespuestasDAO consultasYRespuestasDAO;
	
	@Autowired
	UsuarioDAO usuarioDAO;
	/*@Autowired
	MongoOperations mongoOperations;
	
	private static final String RUTAS = "rutas";
	
	public AdministradorDeRutas(MongoOperations mongoOperations) {
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
	
	public LinkedList<Estacion> obtenerRutaMasCercana(Consulta consulta){
		RutaGeneral rutaGeneral = rutaGeneralDAO.obtenerRutaGeneral();
		Dijkstra dijkstra = new Dijkstra(rutaGeneral);
        dijkstra.execute(rutaGeneral.getVertexes().get(consulta.getEstacionOrigen()-1));
        return dijkstra.getPath(rutaGeneral.getVertexes().get(
        		consulta.getEstacionDestino()-1));
	}
	
	public int obtenerTiempo(Consulta consulta){
		RutaGeneral rutaGeneral = rutaGeneralDAO.obtenerRutaGeneral();
		Dijkstra dijkstra = new Dijkstra(rutaGeneral);
        dijkstra.execute(rutaGeneral.getVertexes().get(consulta.getEstacionOrigen()-1));
        return dijkstra.getShortestDistance(rutaGeneral.getVertexes().get(
        		consulta.getEstacionDestino()-1));
	}
	
	public void crearRespuesta(String idUsuario, Consulta consulta) {
		Respuesta respuesta = new Respuesta(obtenerTiempo(consulta),
				consulta, new ArrayList<>(obtenerRutaMasCercana(consulta)));
		if(existeElUsuario(idUsuario)) {
			consultasYRespuestasDAO.actualizarRespuestasUsuario(respuesta, idUsuario);
		}else {
			consultasYRespuestasDAO.crearUsuario(respuesta, idUsuario);
		}	
	}
	
	public boolean existeElUsuario(String idUsuario) {
		return usuarioDAO.existeElUsuario(idUsuario);
	}
	
	public List<Respuesta> obtenerRespuestasEntregadasPorElUsuario(String idUsuario){
		return consultasYRespuestasDAO.obtenerRespuestasPorUsuario(idUsuario);
	}
	
	public int obtenerRolDelUsuario(String idUsuario) {
		return usuarioDAO.obtenerRolDelUsuario(idUsuario);
	}
}
