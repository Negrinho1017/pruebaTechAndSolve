package com.techAndSolve.subway.persistencia.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import com.techAndSolve.subway.dominio.Rutas;
import com.techAndSolve.subway.persistencia.builder.RutasBuilder;
import com.techAndSolve.subway.persistencia.entidad.RutasEntidad;
import com.techAndSolve.subway.persistencia.interfaz.RutasDAO;

public class RutasDAOImplementacion implements RutasDAO{

private static final String RUTAS = "rutas";
	@Autowired
	MongoOperations mongoOperations;

	public RutasDAOImplementacion(MongoOperations mongoOperations) {
		super();
		this.mongoOperations = mongoOperations;
	}
	
	@Override
	public Rutas obtenerRutas() {
		Query pruebaPorId = query(where("idRutas").is(1));
		RutasEntidad rutasEntidad = mongoOperations.find(pruebaPorId, RutasEntidad.class, RUTAS).get(0);
		return RutasBuilder.convertirDeEntidadADominio(rutasEntidad);
	}

}
