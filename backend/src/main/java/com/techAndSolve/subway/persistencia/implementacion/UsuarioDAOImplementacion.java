package com.techAndSolve.subway.persistencia.implementacion;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.techAndSolve.subway.dominio.Usuario;
import com.techAndSolve.subway.persistencia.interfaz.UsuarioDAO;

public class UsuarioDAOImplementacion implements UsuarioDAO {
	
	private static final String USUARIO = "usuario";
	@Autowired
	MongoOperations mongoOperations;
	
	public UsuarioDAOImplementacion(MongoOperations mongoOperations) {
		super();
		this.mongoOperations = mongoOperations;
	}
	
	@Override
	public boolean existeElUsuario(String idUsuario) {
		Query usuario = query(where("identificacion").is(idUsuario));
		return mongoOperations.exists(usuario, USUARIO);
	}

	@Override
	public int obtenerRolDelUsuario(String idUsuario) {
		Query usuario = query(where("identificacion").is(idUsuario));
		return mongoOperations.find(usuario, Usuario.class, USUARIO).get(0).getRol();
	}
	
	
}
