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

import com.techAndSolve.subway.persistencia.entidad.RutasEntidad;
import com.techAndSolve.subway.persistencia.implementacion.RutasDAOImplementacion;

@RunWith(MockitoJUnitRunner.class)
public class RutasDAOTest {
	@InjectMocks
	RutasDAOImplementacion rutasDAO;
	
	@Mock
	MongoOperations mongoOperations;
	
	List<Integer> rutaA; 
	List<Integer> rutaB;
	List<Integer> rutaC;
	List<Integer> rutaD;
	List<Integer> rutaE;
	List<Integer> rutaF;
	RutasEntidad rutasEntidad;
	List<RutasEntidad> listaRutasEntidad;
	
	@Before
	public void setUp() {
		rutaA = new ArrayList<>();
		rutaB = new ArrayList<>();
		rutaC = new ArrayList<>();
		rutaD = new ArrayList<>();
		rutaE = new ArrayList<>();
		rutaF = new ArrayList<>();
		rutaA.add(1);
		rutaA.add(2);
		rutaA.add(3);
		rutaB.add(2);
		rutaB.add(5);
		rutaC.add(4);
		rutaC.add(6);
		rutaD.add(1);
		rutaD.add(8);
		rutaE.add(7);
		rutaE.add(6);
		rutaF.add(8);
		rutaF.add(9);
		rutasEntidad = new RutasEntidad(rutaA, rutaB, rutaC, rutaD, rutaE, rutaF);
		listaRutasEntidad = new ArrayList<>();
		listaRutasEntidad.add(rutasEntidad);
	}
	
	@Test
	public void obtenerRutasTest() {
		when(mongoOperations.find(any(Query.class), eq(RutasEntidad.class), anyString())).thenReturn(listaRutasEntidad);
		assertEquals(1, (int)rutasDAO.obtenerRutas().getRutaA().get(0));
		assertEquals(5, (int)rutasDAO.obtenerRutas().getRutaB().get(1));
		assertEquals(6, (int)rutasDAO.obtenerRutas().getRutaC().get(1));
		assertEquals(1, (int)rutasDAO.obtenerRutas().getRutaD().get(0));
		assertEquals(6, (int)rutasDAO.obtenerRutas().getRutaE().get(1));
		assertEquals(9, (int)rutasDAO.obtenerRutas().getRutaF().get(1));
	}
}
