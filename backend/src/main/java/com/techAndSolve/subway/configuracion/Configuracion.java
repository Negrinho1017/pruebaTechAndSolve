package com.techAndSolve.subway.configuracion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.techAndSolve.subway.servicio.AdministradorDeRutas;

@Configuration
public class Configuracion {
	@Value("${spring.data.mongodb.host}") 
	private String mongoHost;
	
	@Value("${spring.data.mongodb.port}") 
	private int mongoPuerto;
	
	@Value("${nombreDB}") 
	private String nombreDB;
	
	@Bean
	public AdministradorDeRutas crearProbador(MongoOperations mongoOperations) {
		return new AdministradorDeRutas(mongoOperations);
	}
	
	@Bean
	public MongoClient crearMongoClient() {
		return new MongoClient(mongoHost, mongoPuerto);
	}
	
	@Primary
	@Bean
	public MongoOperations crearMongoTemplate() {	
		return new MongoTemplate(crearMongoClient(), nombreDB);
	}
}
