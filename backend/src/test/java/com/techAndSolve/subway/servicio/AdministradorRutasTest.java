package com.techAndSolve.subway.servicio;

import static org.junit.Assert.assertEquals;
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
import com.techAndSolve.subway.dominio.RutaGeneral;
import com.techAndSolve.subway.persistencia.interfaz.RutaGeneralDAO;

@RunWith(MockitoJUnitRunner.class)
public class AdministradorRutasTest {
	@InjectMocks
	AdministradorRutas administradorRutas;
	
	@Mock
	RutaGeneralDAO rutaGeneralDAO;
	
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
		assertEquals("Poblado", administradorRutas.obtenerRutaMasCercana(consulta).get(0).getName());
		assertEquals("Industriales", administradorRutas.obtenerRutaMasCercana(consulta).get(1).getName());
	}
	
	@Test
	public void obtenerTiempoTest() {
		when(rutaGeneralDAO.obtenerRutaGeneral()).thenReturn(rutaGeneral);
		assertEquals(5, administradorRutas.obtenerTiempo(consulta));
	}
}
