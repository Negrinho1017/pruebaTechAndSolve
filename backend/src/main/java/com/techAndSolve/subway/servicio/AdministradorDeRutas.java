package com.techAndSolve.subway.servicio;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.techAndSolve.subway.dominio.Rutas;

public class AdministradorDeRutas {
	@Autowired
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
}
