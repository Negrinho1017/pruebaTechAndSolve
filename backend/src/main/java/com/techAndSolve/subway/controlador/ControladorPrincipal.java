package com.techAndSolve.subway.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techAndSolve.subway.dominio.Respuesta;
import com.techAndSolve.subway.dominio.Usuario;
import com.techAndSolve.subway.servicio.AdministradorDatosUsuario;
import com.techAndSolve.subway.servicio.AdministradorRutas;

@CrossOrigin
@RestController
@RequestMapping(value = "/")
public class ControladorPrincipal {

	
	@Autowired
	AdministradorDatosUsuario administradorDatosUsuario;
	
	@Autowired
	AdministradorRutas administradorRutas;
	
	@RequestMapping(value = "/respuestas-por-usuario", method = RequestMethod.GET)
	@ResponseBody
	public List<Respuesta> obtenerRespuestasEntregadasAlUsuario(@RequestParam String idUsuario)  {
		return administradorDatosUsuario.obtenerRespuestasEntregadasPorElUsuario(idUsuario);
	}
	
	@RequestMapping(value = "/rol-usuario", method = RequestMethod.GET)
	@ResponseBody
	public int rolDelUsuario(@RequestParam String idUsuario)  {
		return administradorDatosUsuario.obtenerRolDelUsuario(idUsuario);
	}
	
	@RequestMapping(value = "/ingreso-al-sistema", method = RequestMethod.GET)
	@ResponseBody
	public Usuario ingresarAlSistema(@RequestParam String idUsuario, @RequestParam String nombreUsuario)  {
		return administradorDatosUsuario.hayInicioDeSesion(idUsuario, nombreUsuario);
	}
}
