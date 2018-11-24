package com.techAndSolve.subway.persistencia;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
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

import com.techAndSolve.subway.dominio.CaminoEntreEstaciones;
import com.techAndSolve.subway.dominio.Estacion;
import com.techAndSolve.subway.dominio.RutaGeneral;
import com.techAndSolve.subway.persistencia.entidad.CaminoEntreEstacionesEntidad;
import com.techAndSolve.subway.persistencia.entidad.EstacionEntidad;
import com.techAndSolve.subway.persistencia.entidad.RutaGeneralEntidad;
import com.techAndSolve.subway.persistencia.entidad.UsuarioEntidad;
import com.techAndSolve.subway.persistencia.implementacion.RutaGeneralDAOImplementacion;

@RunWith(MockitoJUnitRunner.class)
public class RutaGeneralDAOTest {
	@InjectMocks
	RutaGeneralDAOImplementacion rutaGeneralDAO;
	
	@Mock
	MongoOperations mongoOperations;
	
	Estacion e1;
	Estacion e2;
	Estacion e3;
	Estacion e4;
	CaminoEntreEstaciones c1_2;
	CaminoEntreEstaciones c2_3;
	CaminoEntreEstaciones c2_4;
	List<Estacion> estaciones;
	List<CaminoEntreEstaciones> caminos;
	RutaGeneral rutaGeneral;
	
	EstacionEntidad e1Entidad;
	EstacionEntidad e2Entidad;
	EstacionEntidad e3Entidad;
	EstacionEntidad e4Entidad;
	CaminoEntreEstacionesEntidad c1_2Entidad;
	CaminoEntreEstacionesEntidad c2_3Entidad;
	CaminoEntreEstacionesEntidad c2_4Entidad;
	List<EstacionEntidad> estacionesEntidad;
	List<CaminoEntreEstacionesEntidad> caminosEntidad;
	RutaGeneralEntidad rutaGeneralEntidad;
	List<RutaGeneral> rutasGenerales;
	List<RutaGeneralEntidad> rutasGeneralesEntidad;
	
	@Before
	public void setUp() {
		e1 = new Estacion("1", "1");
		e2 = new Estacion("2", "2");
		e3 = new Estacion("3", "3");
		e4 = new Estacion("4", "4");
		estaciones = new ArrayList<>();
		estaciones.add(e1);
		estaciones.add(e2);
		estaciones.add(e3);
		estaciones.add(e4);
		c1_2 = new CaminoEntreEstaciones("1_2", e1, e2, 4);
		c2_3 = new CaminoEntreEstaciones("2_3", e2, e3, 7);
		c2_4 = new CaminoEntreEstaciones("2_4", e2, e4, 6);
		caminos = new ArrayList<>();
		caminos.add(c1_2);
		caminos.add(c2_3);
		caminos.add(c2_4);
		rutaGeneral = new RutaGeneral(estaciones,caminos);
		rutasGenerales = new ArrayList<>();
		rutasGenerales.add(rutaGeneral);
		
		e1Entidad = new EstacionEntidad("1", "1");
		e2Entidad = new EstacionEntidad("2", "2");
		e3Entidad = new EstacionEntidad("3", "3");
		e4Entidad = new EstacionEntidad("4", "4");
		estacionesEntidad = new ArrayList<>();
		estacionesEntidad.add(e1Entidad);
		estacionesEntidad.add(e2Entidad);
		estacionesEntidad.add(e3Entidad);
		estacionesEntidad.add(e4Entidad);
		c1_2Entidad = new CaminoEntreEstacionesEntidad("1_2", e1Entidad, e2Entidad, 4);
		c2_3Entidad = new CaminoEntreEstacionesEntidad("2_3", e2Entidad, e3Entidad, 7);
		c2_4Entidad = new CaminoEntreEstacionesEntidad("2_4", e2Entidad, e4Entidad, 6);
		caminosEntidad = new ArrayList<>();
		caminosEntidad.add(c1_2Entidad);
		caminosEntidad.add(c2_3Entidad);
		caminosEntidad.add(c2_4Entidad);
		rutaGeneralEntidad = new RutaGeneralEntidad(estacionesEntidad,caminosEntidad);
		rutasGeneralesEntidad = new ArrayList<>();
		rutasGeneralesEntidad.add(rutaGeneralEntidad);
	}
	
	@Test
	public void obtenerRutaGeneral() {
		when(mongoOperations.find(any(Query.class), eq(RutaGeneralEntidad.class), anyString())).thenReturn(rutasGeneralesEntidad);
		assertEquals("1_2", rutaGeneralDAO.obtenerRutaGeneral().getEdges().get(0).getId());
		assertEquals("1", rutaGeneralDAO.obtenerRutaGeneral().getVertexes().get(0).getId());
		assertEquals(RutaGeneral.class, rutaGeneralDAO.obtenerRutaGeneral().getClass());
		assertEquals(CaminoEntreEstaciones.class, rutaGeneralDAO.obtenerRutaGeneral().getEdges().get(0).getClass());
	}
}
