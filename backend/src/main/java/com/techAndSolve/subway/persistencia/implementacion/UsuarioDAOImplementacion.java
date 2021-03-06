package com.techAndSolve.subway.persistencia.implementacion;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.techAndSolve.subway.dominio.Usuario;
import com.techAndSolve.subway.dominio.constantes.Roles;
import com.techAndSolve.subway.persistencia.builder.UsuarioBuilder;
import com.techAndSolve.subway.persistencia.entidad.UsuarioEntidad;
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
		return mongoOperations.find(usuario, UsuarioEntidad.class, USUARIO).get(0).getRol();
	}

	@Override
	public boolean datosIngresadosCorrectamente(String idUsuario, String nombreUsuario) {
		Query usuario = query(where("nombreUsuario").is(nombreUsuario)
				.and("identificacion").is(idUsuario));
		return mongoOperations.exists(usuario, USUARIO);
	}

	@Override
	public Usuario obtenerUsuarioPorId(String idUsuario) {
		Query usuario = query(where("identificacion").is(idUsuario));
		UsuarioEntidad usuarioEntidad = mongoOperations.find(usuario, UsuarioEntidad.class, USUARIO).get(0);
		return UsuarioBuilder.convertirDeEntidadADominio(usuarioEntidad);
	}

	@Override
	public void crearUsuario(String idUsuario, String nombreUsuario) {
		Usuario usuario = new Usuario(Roles.USUARIO_CORRIENTE.getValue(), new ArrayList<>(), idUsuario, nombreUsuario);
		mongoOperations.save(UsuarioBuilder.convertirDeDominioAEntidad(usuario), USUARIO);		
	}
}
