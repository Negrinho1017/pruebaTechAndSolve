package com.techAndSolve.subway.controlador;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techAndSolve.subway.dominio.Consulta;
import com.techAndSolve.subway.dominio.DatosUsuario;
import com.techAndSolve.subway.dominio.Estacion;
import com.techAndSolve.subway.dominio.SubRuta;
import com.techAndSolve.subway.dominio.Usuario;
import com.techAndSolve.subway.servicio.AdministradorDatosUsuario;
import com.techAndSolve.subway.servicio.AdministradorRutas;

@CrossOrigin
@RestController
@RequestMapping(value = "/consultas")
public class ControladorConsultas {

	@Autowired
	AdministradorDatosUsuario administradorDatosUsuario;
	
	@Autowired
	AdministradorRutas administradorRutas;
	
	@RequestMapping(value = "/creacion-respuesta/{estacionOrigen}/{estacionDestino}", method = RequestMethod.POST)
	@ResponseBody
	public void crearRespuesta(@RequestBody Usuario usuario,
			@PathVariable(value = "estacionOrigen") int estacionOrigen,
			@PathVariable(value = "estacionDestino") int estacionDestino) {
		administradorDatosUsuario.crearRespuesta(usuario.getIdentificacion(),
				new Consulta(estacionOrigen, estacionDestino));
	}
	
	@RequestMapping(value = "/datos-usuario", method = RequestMethod.GET)
	@ResponseBody
	public DatosUsuario obtenerDatosUsuario(@RequestParam int estacionOrigen,
			@RequestParam int estacionDestino)  {
		int tiempo = administradorRutas.obtenerTiempo(new Consulta(
				estacionOrigen, estacionDestino));;
		LinkedList<Estacion> rutaMasCorta = administradorRutas.obtenerRutaMasCercana(new Consulta(
				estacionOrigen, estacionDestino));;
		return new DatosUsuario(tiempo, rutaMasCorta);
	}
	
	@RequestMapping(value = "/rutas", method = RequestMethod.GET)
	@ResponseBody
	public List<SubRuta> obtenerRutasASeguir(@RequestParam int estacionOrigen,
			@RequestParam int estacionDestino)  {
		return administradorRutas.obtenerListadoDeRutasASeguir(
				new Consulta(estacionOrigen, estacionDestino));
	}
}
