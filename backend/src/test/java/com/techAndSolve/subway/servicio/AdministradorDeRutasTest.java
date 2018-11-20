package com.techAndSolve.subway.servicio;

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
import com.techAndSolve.subway.dominio.RutaGeneral;
import com.techAndSolve.subway.persistencia.interfaz.ConsultasYRespuestasDAO;
import com.techAndSolve.subway.persistencia.interfaz.RutaGeneralDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AdministradorDeRutasTest {
	@InjectMocks
	AdministradorDeRutas administradorDeRutas;
	
	@Mock
	RutaGeneralDAO rutaGeneralDAO;
	
	@Mock
	ConsultasYRespuestasDAO consultasYRespuestasDAO;
	
	Estacion e1;
	Estacion e2;
	List<Estacion> estaciones;
	CaminoEntreEstaciones c1_2;
	CaminoEntreEstaciones c2_1;
	List<CaminoEntreEstaciones> caminos;
	RutaGeneral rutaGeneral;
	Consulta consulta;
	
	@Before
	public void setUp() { 
		e1 = new Estacion("1", "Poblado");
		e2 = new Estacion("2", "Industriales");
		estaciones = new ArrayList<>();
		consulta = new Consulta(1,2);
		estaciones.add(e1);
		estaciones.add(e2);
		c1_2 = new CaminoEntreEstaciones("1_2", e1, e2, 5);
		c2_1 = new CaminoEntreEstaciones("2_1", e2, e1, 5);
		caminos = new ArrayList<>();
		caminos.add(c1_2);
		caminos.add(c2_1);
		rutaGeneral = new RutaGeneral(estaciones, caminos);
	}
	
	@Test
	public void obtenerRutaMasCercanaTest() {
		when(rutaGeneralDAO.obtenerRutaGeneral()).thenReturn(rutaGeneral);
		assertEquals("Poblado", administradorDeRutas.obtenerRutaMasCercana(consulta).get(0).getName());
		assertEquals("Industriales", administradorDeRutas.obtenerRutaMasCercana(consulta).get(1).getName());
	}
	
	@Test
	public void obtenerTiempoTest() {
		when(rutaGeneralDAO.obtenerRutaGeneral()).thenReturn(rutaGeneral);
		assertEquals(5, administradorDeRutas.obtenerTiempo(consulta));
	}
	
	 @Test
	 public void existeElUsuarioTest(){
		 when(consultasYRespuestasDAO.existeElUsuario("1234")).thenReturn(true);
		 assertTrue(administradorDeRutas.existeElUsuario("1234"));
		 assertFalse(administradorDeRutas.existeElUsuario("12345"));
	 }
}
