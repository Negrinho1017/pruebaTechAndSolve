package com.techAndSolve.subway.controlador;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techAndSolve.subway.dominio.Consulta;
import com.techAndSolve.subway.dominio.Estacion;
import com.techAndSolve.subway.dominio.Respuesta;
import com.techAndSolve.subway.dominio.Usuario;
import com.techAndSolve.subway.servicio.AdministradorDeRutas;

@RestController
@RequestMapping(value = "/")
public class ControladorPrincipal {

	
	@Autowired
	AdministradorDeRutas administradorDeRutas;
	
	@RequestMapping(value = "/ruta-mas-corta", method = RequestMethod.GET)
	@ResponseBody
	public LinkedList<Estacion> obtenerRutaMasCercana(@RequestParam int estacionOrigen,
			@RequestParam int estacionDestino)  {
		return administradorDeRutas.obtenerRutaMasCercana(new Consulta(
				estacionOrigen, estacionDestino));
	}
	
	@RequestMapping(value = "/tiempo", method = RequestMethod.GET)
	@ResponseBody
	public int obtenerTiempo(@RequestParam int estacionOrigen,
			@RequestParam int estacionDestino)  {
		return administradorDeRutas.obtenerTiempo(new Consulta(
				estacionOrigen, estacionDestino));
	}
	
	@RequestMapping(value = "/respuestas-por-usuario", method = RequestMethod.GET)
	@ResponseBody
	public List<Respuesta> obtenerRespuestasEntregadasAlUsuario(@RequestParam String idUsuario)  {
		return administradorDeRutas.obtenerRespuestasEntregadasPorElUsuario(idUsuario);
	}
	
	@RequestMapping(value = "/rol-usuario", method = RequestMethod.GET)
	@ResponseBody
	public int rolDelUsuario(@RequestParam String idUsuario)  {
		return administradorDeRutas.obtenerRolDelUsuario(idUsuario);
	}
	
	@RequestMapping(value = "/creacion-respuesta/{estacionOrigen}/{estacionDestino}", method = RequestMethod.POST)
	@ResponseBody
	public void crearRespuesta(@RequestBody Usuario usuario,
			@PathVariable(value = "estacionOrigen") int estacionOrigen,
			@PathVariable(value = "estacionDestino") int estacionDestino) {
		administradorDeRutas.crearRespuesta(usuario.getIdentificacion(),
				new Consulta(estacionOrigen, estacionDestino));
	}
}
