package com.techAndSolve.subway.persistencia.implementacion;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.techAndSolve.subway.dominio.RutaGeneral;
import com.techAndSolve.subway.persistencia.builder.RutaGeneralBuilder;
import com.techAndSolve.subway.persistencia.entidad.RutaGeneralEntidad;
import com.techAndSolve.subway.persistencia.interfaz.RutaGeneralDAO;

public class RutaGeneralDAOImplementacion implements RutaGeneralDAO{

	@Autowired
	MongoOperations mongoOperations;
	
	private static final String RUTA_GENERAL = "rutaGeneral";
	
	public RutaGeneralDAOImplementacion(MongoOperations mongoOperations) {
		super();
		this.mongoOperations = mongoOperations;
	}
	
	@Override
	public RutaGeneral obtenerRutaGeneral() {
		Query rutaGeneral = query(where("idRutaGeneral").is(1));
		RutaGeneralEntidad rutaGeneralEntidad = mongoOperations.find(rutaGeneral, RutaGeneralEntidad.class, RUTA_GENERAL).get(0);
		return RutaGeneralBuilder.convertirDeEntidadADominio(rutaGeneralEntidad);
	}
	
}
