import { Component, OnInit } from '@angular/core';
import { ConsultasService } from './consultas.service';
import { DatosUsuario } from '../model/DatosUsuario';
import swal from 'sweetalert2';
import { DatosGlobales } from '../datosGlobales';
import { Usuario } from '../model/Usuario';

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
        this.mensajeExito("La ruta más corta es: " +
          this.datosUsuario.rutaMasCorta.map(estacion => estacion.name) +
          " y el tiempo estimado es: " + this.datosUsuario.tiempo);       
      }, error => {
        this.mensajeError(error.error.mensaje);
      });
      this.crearRespuesta();
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

}
