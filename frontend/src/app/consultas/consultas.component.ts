import { Component, OnInit } from '@angular/core';
import { ConsultasService } from './consultas.service';
import { DatosUsuario } from '../model/DatosUsuario';
import swal from 'sweetalert2';
import { DatosGlobales } from '../datosGlobales';
import { Usuario } from '../model/Usuario';
import { SubRuta } from '../model/SubRuta';

@Component({
  selector: 'app-consultas',
  templateUrl: './consultas.component.html',
  styleUrls: ['./consultas.component.css']
})
export class ConsultasComponent implements OnInit {
  estacionOrigenSeleccionada: number;
  estacionDestinoSeleccionada: number;
  listaEstaciones: number[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];
  rutaMasCorta: String[];
  datosUsuario: DatosUsuario;
  usuario: Usuario 
  constructor(private consultasService: ConsultasService, private datosGlobales: DatosGlobales) { }

  ngOnInit() {
    this.rutaMasCorta = [];
  }

  buscar() {
    this.consultasService.obtenerDatosUsuario(this.estacionOrigenSeleccionada, this.estacionDestinoSeleccionada)
      .subscribe(res => {
        this.datosUsuario = res;
        var mensaje = "La ruta más corta es: " +
        this.datosUsuario.rutaMasCorta.map(estacion => estacion.name) +
        " y el tiempo estimado es: " + this.datosUsuario.tiempo + " minutos";
        var rutas = this.rutasASeguir(this.datosUsuario.subRutas);
        this.mensajeRutas(mensaje, rutas); 
      }, error => {
        this.mensajeError(error.error.mensaje);
      });
      this.crearRespuesta();
  }

  rutasASeguir(listaSubRutas: SubRuta[]): String {
    var mensaje = "";
    for (let subRuta of listaSubRutas) {
      mensaje = mensaje + "Ruta "+subRuta.nombre + ": Estación origen - " + subRuta.estacionOrigen+ " Estación destino - "
      +subRuta.estacionDestino+ ".<br/>";
    } 
    return mensaje;
  }

  crearRespuesta() {
    this.usuario = new Usuario();
    this.usuario.identificacion = this.datosGlobales.usuarioActual.identificacion;
    this.usuario.nombreUsuario = this.datosGlobales.usuarioActual.nombreUsuario;
    this.consultasService.crearRespuesta(this.usuario, this.estacionOrigenSeleccionada,
    this.estacionDestinoSeleccionada).subscribe(res => {
      }, error => {
        this.mensajeError(error.error.mensaje);
      });
  }

  mensajeError(mensaje: String) {
    swal({
      type: 'error',
      title: 'Error!!',
      text: <string>mensaje
    })
  }

  mensajeExito(mensaje: String) {
    swal({
      type: 'success',
      title: 'Bienvenido!!',
      text: <string>mensaje
    })
  }

  mensajeRutas(mensaje: String, rutas: String){
    swal({
      title: 'Bienvenido!!',
      text: <string> mensaje,
      type: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Mostrar rutas',
      cancelButtonText: 'Salir'
    }).then((result) => {
      if (result.value) {
        swal(<string> rutas)
      }
    })
  }

}
