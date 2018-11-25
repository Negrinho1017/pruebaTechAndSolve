package com.techAndSolve.subway.servicio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
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
import com.techAndSolve.subway.dominio.Rutas;
import com.techAndSolve.subway.persistencia.interfaz.RutaGeneralDAO;
import com.techAndSolve.subway.persistencia.interfaz.RutasDAO;

@RunWith(MockitoJUnitRunner.class)
public class AdministradorRutasTest {
	@InjectMocks
	AdministradorRutas administradorRutas;
	
	@Mock
	RutaGeneralDAO rutaGeneralDAO;
	
	@Mock
	RutasDAO rutasDAO;
	
	Estacion e1;
	Estacion e2;
	Estacion e3;
	Estacion e4;
	List<Estacion> estaciones;
	CaminoEntreEstaciones c1_2;
	CaminoEntreEstaciones c2_1;
	CaminoEntreEstaciones c2_3;
	CaminoEntreEstaciones c3_2;
	CaminoEntreEstaciones c2_4;
	CaminoEntreEstaciones c4_2;
	List<CaminoEntreEstaciones> caminos;
	RutaGeneral rutaGeneral;
	Consulta consulta;
	Consulta consultaMayor;
	List<Integer> rutaA;
	List<Integer> rutaB;
	List<Integer> rutaC;
	List<Integer> rutaD;
	List<Integer> rutaE;
	List<Integer> rutaF;
	Rutas rutas;
	
	@Before
	public void setUp() { 
		e1 = new Estacion("1", "Poblado");
		e2 = new Estacion("2", "Industriales");
		e3 = new Estacion("3", "Exposiciones");
		e4 = new Estacion("4", "Suramericana");
		estaciones = new ArrayList<>();
		consulta = new Consulta(1,2);
		Collections.addAll(estaciones, e1, e2, e3, e4);
		c1_2 = new CaminoEntreEstaciones("1_2", e1, e2, 4);
		c2_1 = new CaminoEntreEstaciones("2_1", e2, e1, 4);
		c2_3 = new CaminoEntreEstaciones("2_3", e2, e3, 4);
		c3_2 = new CaminoEntreEstaciones("3_2", e3, e2, 4);
		c2_4 = new CaminoEntreEstaciones("2_4", e2, e4, 4);
		c4_2 = new CaminoEntreEstaciones("4_2", e4, e2, 4);
		caminos = new ArrayList<>();
		Collections.addAll(caminos, c1_2, c2_1, c2_3, c3_2, c2_4, c4_2);
		rutaGeneral = new RutaGeneral(estaciones, caminos);
		rutaA = new ArrayList<>();
		Collections.addAll(rutaA, 1, 2, 3);
		rutaB = new ArrayList<>();
		Collections.addAll(rutaB, 1, 2, 4);
		rutaC = new ArrayList<>();
		Collections.addAll(rutaC, 1, 2, 3);
		rutaD = new ArrayList<>();
		Collections.addAll(rutaD, 2, 4);
		rutaE = new ArrayList<>();
		Collections.addAll(rutaE, 3, 2);
		rutaF = new ArrayList<>();
		Collections.addAll(rutaF, 2, 3);
		rutas = new Rutas(rutaA, rutaB, rutaC, rutaD, rutaE, rutaF);
		consultaMayor = new Consulta(3, 4);
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
		assertEquals(4, administradorRutas.obtenerTiempo(consulta));
	}
	
	@Test
	public void obtenerListadoDeRutasASeguirTest() {
		when(rutasDAO.obtenerRutas()).thenReturn(rutas);
		when(rutaGeneralDAO.obtenerRutaGeneral()).thenReturn(rutaGeneral);
		assertEquals(2, administradorRutas.obtenerListadoDeRutasASeguir(consultaMayor).size());
		assertEquals(3, administradorRutas.obtenerListadoDeRutasASeguir(consultaMayor).get(0).getEstacionOrigen());
		assertEquals(2, administradorRutas.obtenerListadoDeRutasASeguir(consultaMayor).get(0).getEstacionDestino());
		assertEquals(2, administradorRutas.obtenerListadoDeRutasASeguir(consultaMayor).get(1).getEstacionOrigen());
		assertEquals(4, administradorRutas.obtenerListadoDeRutasASeguir(consultaMayor).get(1).getEstacionDestino());
	}
	
	@Test
	public void obtenerDatosRequeridosPorElUsuarioTest() {
		when(rutasDAO.obtenerRutas()).thenReturn(rutas);
		when(rutaGeneralDAO.obtenerRutaGeneral()).thenReturn(rutaGeneral);
		assertEquals(10, administradorRutas.obtenerDatosRequeridosPorElUsuario(consultaMayor).getTiempo());
		assertEquals("Exposiciones", administradorRutas.obtenerDatosRequeridosPorElUsuario(consultaMayor).getRutaMasCorta().get(0).getName());
		assertEquals("Industriales", administradorRutas.obtenerDatosRequeridosPorElUsuario(consultaMayor).getRutaMasCorta().get(1).getName());
		assertEquals("Suramericana", administradorRutas.obtenerDatosRequeridosPorElUsuario(consultaMayor).getRutaMasCorta().get(2).getName());
		assertEquals(3, administradorRutas.obtenerDatosRequeridosPorElUsuario(consultaMayor).getRutaMasCorta().size());
		assertEquals(2, administradorRutas.obtenerDatosRequeridosPorElUsuario(consultaMayor).getSubRutas().get(0).getEstacionDestino());
		assertEquals(2, administradorRutas.obtenerDatosRequeridosPorElUsuario(consultaMayor).getSubRutas().get(1).getEstacionOrigen());
	}
}
