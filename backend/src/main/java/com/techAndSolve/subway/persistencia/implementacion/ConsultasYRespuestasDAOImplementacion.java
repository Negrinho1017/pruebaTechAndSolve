package com.techAndSolve.subway.persistencia.implementacion;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.techAndSolve.subway.dominio.Respuesta;
import com.techAndSolve.subway.dominio.Usuario;
import com.techAndSolve.subway.dominio.constantes.Roles;
import com.techAndSolve.subway.persistencia.builder.RespuestaBuilder;
import com.techAndSolve.subway.persistencia.builder.UsuarioBuilder;
import com.techAndSolve.subway.persistencia.entidad.RespuestaEntidad;
import com.techAndSolve.subway.persistencia.entidad.UsuarioEntidad;
import com.techAndSolve.subway.persistencia.interfaz.ConsultasYRespuestasDAO;

public class ConsultasYRespuestasDAOImplementacion implements ConsultasYRespuestasDAO{

	private static final String USUARIO = "usuario";
	@Autowired
	MongoOperations mongoOperations;
	
	public ConsultasYRespuestasDAOImplementacion(MongoOperations mongoOperations) {
		super();
		this.mongoOperations = mongoOperations;
	}
	
	@Override
	public void crearRespuesta(Respuesta respuesta, String idUsuario) {
		List<Respuesta> respuestas = new ArrayList<>();
		respuestas.add(respuesta);
		UsuarioEntidad usuarioEntidad = UsuarioBuilder.convertirDeDominioAEntidad(
				new Usuario(Roles.USUARIO_CORRIENTE.getValue(),respuestas, idUsuario, idUsuario));
		mongoOperations.save(usuarioEntidad, USUARIO);	
	}

	@Override
	public List<Respuesta> obtenerRespuestasPorUsuario(String idUsuario) {
		Query usuario = query(where("identificacion").is(idUsuario));
		UsuarioEntidad usuarioEntidad = mongoOperations.find(usuario, UsuarioEntidad.class, USUARIO).get(0);
		return UsuarioBuilder.convertirDeEntidadADominio(usuarioEntidad).getRespuestasObtenidas();
	}

	@Override
	public void actualizarRespuestasUsuario(Respuesta respuesta, String idUsuario) {
		Query usuario = query(where("identificacion").is(idUsuario));
		UsuarioEntidad usuarioPorId = mongoOperations.find(usuario, UsuarioEntidad.class, USUARIO).get(0);
		List<RespuestaEntidad> respuestas = usuarioPorId.getRespuestasObtenidas();
		respuestas.add(RespuestaBuilder.convertirDeDominioAEntidad(respuesta));
		Update actualizacionRespuestas = update("respuestasObtenidas", respuestas);
		mongoOperations.updateFirst(usuario, actualizacionRespuestas, UsuarioEntidad.class, USUARIO);
	}

}
