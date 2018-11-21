package com.techAndSolve.subway.servicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.techAndSolve.subway.dominio.CaminoEntreEstaciones;
import com.techAndSolve.subway.dominio.Consulta;
import com.techAndSolve.subway.dominio.Estacion;
import com.techAndSolve.subway.dominio.Respuesta;
import com.techAndSolve.subway.dominio.RutaGeneral;
import com.techAndSolve.subway.dominio.excepcion.SubwayException;
import com.techAndSolve.subway.persistencia.interfaz.ConsultasYRespuestasDAO;
import com.techAndSolve.subway.persistencia.interfaz.RutaGeneralDAO;
import com.techAndSolve.subway.persistencia.interfaz.UsuarioDAO;

@RunWith(MockitoJUnitRunner.class)
public class AdministradorDatosUsuarioTest {
	@InjectMocks
	AdministradorDatosUsuario administradorDatosUsuario;
	
	@Mock
	RutaGeneralDAO rutaGeneralDAO;
	
	@Mock
	ConsultasYRespuestasDAO consultasYRespuestasDAO;
	
	@Mock
	UsuarioDAO usuarioDAO;
	
	Estacion e1;
	Estacion e2;
	List<Estacion> estaciones;
	Consulta consulta;
	Respuesta r1;
	Respuesta r2;
	List<Respuesta> respuestas;
	
	@Before
	public void setUp() { 
		e1 = new Estacion("1", "Poblado");
		e2 = new Estacion("2", "Industriales");
		estaciones = new ArrayList<>();
		consulta = new Consulta(1,2);
		estaciones.add(e1);
		estaciones.add(e2);
		r1 = new Respuesta(20, consulta, estaciones);
		r2 = new Respuesta(18, consulta, estaciones);
		respuestas = new ArrayList<>();
		respuestas.add(r1);
		respuestas.add(r2);
	}
	
	 @Test
	 public void existeElUsuarioTest(){
		 when(usuarioDAO.existeElUsuario("1234")).thenReturn(true);
		 assertTrue(administradorDatosUsuario.existeElUsuario("1234"));
		 assertFalse(administradorDatosUsuario.existeElUsuario("12345"));
	 }
	 
	 @Test
	 public void obtenerRespuestasEntregadasPorElUsuarioTest() {
		 when(consultasYRespuestasDAO.obtenerRespuestasPorUsuario("1234")).thenReturn(respuestas);
		 when(usuarioDAO.existeElUsuario("1234")).thenReturn(true);
		 assertEquals(2, administradorDatosUsuario.obtenerRespuestasEntregadasPorElUsuario("1234").size());
		 assertEquals(20, administradorDatosUsuario.obtenerRespuestasEntregadasPorElUsuario("1234").get(0).getTiempo());
		 assertEquals(18, administradorDatosUsuario.obtenerRespuestasEntregadasPorElUsuario("1234").get(1).getTiempo());
	 }
	 
	 @Test(expected = SubwayException.class)
	 public void obtenerRespuestasEntregadasPorElUsuarioConUusarioNoEncontradoTest() {
		 when(usuarioDAO.existeElUsuario("1234")).thenReturn(false);
		 administradorDatosUsuario.obtenerRespuestasEntregadasPorElUsuario("1234");
	 }
	 
	 @Test
	 public void obtenerRolDelUsuarioTest() {
		 when(usuarioDAO.obtenerRolDelUsuario("1234")).thenReturn(1);
		 assertEquals(1, administradorDatosUsuario.obtenerRolDelUsuario("1234"));
	 }
}
