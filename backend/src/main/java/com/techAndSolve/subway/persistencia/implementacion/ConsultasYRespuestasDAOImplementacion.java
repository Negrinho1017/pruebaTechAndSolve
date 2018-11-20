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
	public void crearUsuario(Respuesta respuesta, String idUsuario) {
		List<Respuesta> respuestas = new ArrayList<>();
		respuestas.add(respuesta);
		Usuario usuario = new Usuario(Roles.USUARIO_CORRIENTE.getValue(),
				respuestas, idUsuario, idUsuario);
		mongoOperations.save(usuario, USUARIO);	
	}

	@Override
	public List<Respuesta> obtenerRespuestasPorUsuario(String idUsuario) {
		Query usuario = query(where("identificacion").is(idUsuario));
		return mongoOperations.find(usuario, Usuario.class, USUARIO).get(0).getRespuestasObtenidas();
	}

	@Override
	public void actualizarRespuestasUsuario(Respuesta respuesta, String idUsuario) {
		Query usuario = query(where("identificacion").is(idUsuario));
		Usuario usuarioPorId = mongoOperations.find(usuario, Usuario.class, USUARIO).get(0);
		List<Respuesta> respuestas = usuarioPorId.getRespuestasObtenidas();
		respuestas.add(respuesta);
		Update actualizacionRespuestas = update("respuestasObtenidas", respuestas);
		mongoOperations.updateFirst(usuario, actualizacionRespuestas, Usuario.class, USUARIO);
	}

}
