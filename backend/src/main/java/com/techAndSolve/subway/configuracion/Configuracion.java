package com.techAndSolve.subway.configuracion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.techAndSolve.subway.persistencia.implementacion.ConsultasYRespuestasDAOImplementacion;
import com.techAndSolve.subway.persistencia.implementacion.RutaGeneralDAOImplementacion;
import com.techAndSolve.subway.persistencia.implementacion.RutasDAOImplementacion;
import com.techAndSolve.subway.persistencia.implementacion.UsuarioDAOImplementacion;
import com.techAndSolve.subway.servicio.AdministradorDatosUsuario;
import com.techAndSolve.subway.servicio.AdministradorRutas;

@Configuration
public class Configuracion {
	@Value("${spring.data.mongodb.host}") 
	private String mongoHost;
	
	@Value("${spring.data.mongodb.port}") 
	private int mongoPuerto;
	
	@Value("${nombreDB}") 
	private String nombreDB;
	
	@Bean
	public RutaGeneralDAOImplementacion crearRutaGeneralDAO(MongoOperations mongoOperations) {
		return new RutaGeneralDAOImplementacion(mongoOperations);
	}
	
	@Bean
	public UsuarioDAOImplementacion crearUsuarioDAO(MongoOperations mongoOperations) {
		return new UsuarioDAOImplementacion(mongoOperations);
	}
	
	@Bean
	public ConsultasYRespuestasDAOImplementacion crearConsultasYRespuestas(MongoOperations mongoOperations) {
		return new ConsultasYRespuestasDAOImplementacion(mongoOperations);
	}
	
	@Bean
	public RutasDAOImplementacion crearRutasDAO(MongoOperations mongoOperations) {
		return new RutasDAOImplementacion(mongoOperations);
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
	
	@Bean
	public AdministradorDatosUsuario crearAdministradorDatosUusario() {
		return new AdministradorDatosUsuario();
	}
	
	@Bean
	public AdministradorRutas crearAdministradorRutas() {
		return new AdministradorRutas();
	}
}
