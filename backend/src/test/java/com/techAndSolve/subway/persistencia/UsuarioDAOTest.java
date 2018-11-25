package com.techAndSolve.subway.persistencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import com.techAndSolve.subway.dominio.Usuario;
import com.techAndSolve.subway.persistencia.entidad.ConsultaEntidad;
import com.techAndSolve.subway.persistencia.entidad.EstacionEntidad;
import com.techAndSolve.subway.persistencia.entidad.RespuestaEntidad;
import com.techAndSolve.subway.persistencia.entidad.UsuarioEntidad;
import com.techAndSolve.subway.persistencia.implementacion.UsuarioDAOImplementacion;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioDAOTest {
	@InjectMocks
	UsuarioDAOImplementacion usuarioDAO;
	
	@Mock
	MongoOperations mongoOperations;
	
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
	public void existeElUsuarioYDatosIngresadosCorrectamenteTest() {
		when(mongoOperations.exists(any(Query.class), anyString())).thenReturn(true);
		assertTrue(usuarioDAO.existeElUsuario("1234"));
		assertTrue(usuarioDAO.datosIngresadosCorrectamente("1234","1234"));
	}
	
	@Test
	public void obtenerRolDelUsuarioTest() {
		when(mongoOperations.find(any(Query.class), eq(UsuarioEntidad.class), anyString())).thenReturn(listaUsuariosEntidad);
		assertEquals(1, usuarioDAO.obtenerRolDelUsuario("1234"));
	}
	
	@Test
	public void obtenerUsuarioPorIdTest() {
		when(mongoOperations.find(any(Query.class), eq(UsuarioEntidad.class), anyString())).thenReturn(listaUsuariosEntidad);
		assertEquals(Usuario.class, usuarioDAO.obtenerUsuarioPorId("1234").getClass());
		assertEquals("1", usuarioDAO.obtenerUsuarioPorId("1234").getRespuestasObtenidas().get(0).getEstaciones().get(0).getId());
		assertEquals("1234", usuarioDAO.obtenerUsuarioPorId("1234").getIdentificacion());
		verify(mongoOperations, times(3)).find(any(Query.class), eq(UsuarioEntidad.class), anyString());
	}
	
	@Test
	public void crearUsuarioTest() {
		usuarioDAO.crearUsuario("1234", "1234");
		verify(mongoOperations, times(1)).save(any(UsuarioEntidad.class), anyString());
	}

}
