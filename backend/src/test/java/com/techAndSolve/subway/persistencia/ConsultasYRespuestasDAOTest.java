package com.techAndSolve.subway.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;

import com.techAndSolve.subway.dominio.Consulta;
import com.techAndSolve.subway.dominio.Estacion;
import com.techAndSolve.subway.dominio.Respuesta;
import com.techAndSolve.subway.dominio.Usuario;
import com.techAndSolve.subway.persistencia.entidad.ConsultaEntidad;
import com.techAndSolve.subway.persistencia.entidad.EstacionEntidad;
import com.techAndSolve.subway.persistencia.entidad.RespuestaEntidad;
import com.techAndSolve.subway.persistencia.entidad.RutasEntidad;
import com.techAndSolve.subway.persistencia.entidad.UsuarioEntidad;
import com.techAndSolve.subway.persistencia.implementacion.ConsultasYRespuestasDAOImplementacion;

@RunWith(MockitoJUnitRunner.class)
public class ConsultasYRespuestasDAOTest {
	@InjectMocks
	ConsultasYRespuestasDAOImplementacion consultasYRespuestasDAO;
	
	@Mock
	MongoOperations mongoOperations;
	
	List<Respuesta> respuestas;
	Respuesta r1;
	Respuesta r2;
	Consulta consultaRealizada;
	Consulta consultaRealizada2;
	List<Estacion> estaciones;
	List<Estacion> estaciones2;
	Estacion e1;
	Estacion e2;
	Estacion e3;
	Estacion e4;
	
	List<RespuestaEntidad> respuestasEntidad;
	RespuestaEntidad r1Entidad;
	RespuestaEntidad r2Entidad;
	ConsultaEntidad consultaRealizadaEntidad;
	ConsultaEntidad consultaRealizada2Entidad;
	List<EstacionEntidad> estacionesEntidad;
	List<EstacionEntidad> estaciones2Entidad;
	EstacionEntidad e1Entidad;
	EstacionEntidad e2Entidad;
	EstacionEntidad e3Entidad;
	EstacionEntidad e4Entidad;
	
	UsuarioEntidad usuarioEntidad;
	List<UsuarioEntidad> listaUsuariosEntidad;
	
	@Before
	public void setUp() {
		consultaRealizada = new Consulta(1, 2);
		e1 = new Estacion("1", "1");
		e2 = new Estacion("2", "2");
		estaciones = new ArrayList<>();
		estaciones.add(e1);
		estaciones.add(e2);
		respuestas = new ArrayList<>();
		r1 = new Respuesta(4, consultaRealizada, estaciones);
		consultaRealizada2 = new Consulta(3, 4);
		e3 = new Estacion("3", "3");
		e4 = new Estacion("4", "4");
		estaciones2 = new ArrayList<>();
		estaciones2.add(e3);
		estaciones2.add(e4);
		r2 = new Respuesta(4, consultaRealizada2, estaciones);
		respuestas.add(r1);
		respuestas.add(r2);
		
		consultaRealizadaEntidad = new ConsultaEntidad(1, 2);
		e1Entidad = new EstacionEntidad("1", "1");
		e2Entidad = new EstacionEntidad("2", "2");
		estacionesEntidad = new ArrayList<>();
		estacionesEntidad.add(e1Entidad);
		estacionesEntidad.add(e2Entidad);
		respuestasEntidad = new ArrayList<>();
		r1Entidad = new RespuestaEntidad(4, consultaRealizadaEntidad, estacionesEntidad);
		consultaRealizada2Entidad = new ConsultaEntidad(3, 4);
		e3Entidad = new EstacionEntidad("3", "3");
		e4Entidad = new EstacionEntidad("4", "4");
		estaciones2Entidad = new ArrayList<>();
		estaciones2Entidad.add(e3Entidad);
		estaciones2Entidad.add(e4Entidad);
		r2Entidad = new RespuestaEntidad(6, consultaRealizada2Entidad, estaciones2Entidad);
		respuestasEntidad.add(r1Entidad);
		respuestasEntidad.add(r2Entidad);
		
		usuarioEntidad = new UsuarioEntidad(1, respuestasEntidad, "1234", "1234");
		listaUsuariosEntidad = new ArrayList<>();
		listaUsuariosEntidad.add(usuarioEntidad);
	}
	
	@Test
	public void crearRespuestaTest() {
		consultasYRespuestasDAO.crearRespuesta(r1, "123");
		consultasYRespuestasDAO.crearRespuesta(r2, "123");
		verify(mongoOperations, times(2)).save(any(UsuarioEntidad.class), anyString());
	}
	
	@Test
	public void obtenerRespuestasPorUsuarioTest() {
		when(mongoOperations.find(any(Query.class), eq(UsuarioEntidad.class), anyString())).thenReturn(listaUsuariosEntidad);
		assertEquals(2, consultasYRespuestasDAO.obtenerRespuestasPorUsuario("1234").size());
		assertEquals(1, consultasYRespuestasDAO.obtenerRespuestasPorUsuario("1234").get(0).getConsultaRealizada().getEstacionOrigen());
		assertEquals(2, consultasYRespuestasDAO.obtenerRespuestasPorUsuario("1234").get(0).getConsultaRealizada().getEstacionDestino());
		assertEquals("4", consultasYRespuestasDAO.obtenerRespuestasPorUsuario("1234").get(1).getEstaciones().get(1).getId());
		assertEquals(6, consultasYRespuestasDAO.obtenerRespuestasPorUsuario("1234").get(1).getTiempo());
		assertEquals(4, consultasYRespuestasDAO.obtenerRespuestasPorUsuario("1234").get(0).getTiempo());
	}

}
