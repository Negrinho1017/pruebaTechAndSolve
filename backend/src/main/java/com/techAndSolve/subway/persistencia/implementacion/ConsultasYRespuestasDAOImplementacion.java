package com.techAndSolve.subway.persistencia.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

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
		// TODO Auto-generated method stub
		return null;
	}

}
