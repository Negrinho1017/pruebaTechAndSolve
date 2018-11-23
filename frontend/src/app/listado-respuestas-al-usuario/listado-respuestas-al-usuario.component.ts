import { Component, OnInit } from '@angular/core';
import { Respuesta } from '../model/Respuesta';
import { ListadoRespuestasAlUsuarioService } from './listado-respuestas-al-usuario.service';
import swal from 'sweetalert2'
import { Estacion } from '../model/Estacion';
import { DatosGlobales } from '../datosGlobales';

@Component({
  selector: 'app-listado-respuestas-al-usuario',
  templateUrl: './listado-respuestas-al-usuario.component.html',
  styleUrls: ['./listado-respuestas-al-usuario.component.css']
})
export class ListadoRespuestasAlUsuarioComponent implements OnInit {
  respuestas: Respuesta[];
  idUsuario: String;
  estaciones: String[][];
  usuarioEncontrado: boolean = false;
  loading: boolean;
  constructor( private listadoRespuestasAlUsuarioService: ListadoRespuestasAlUsuarioService,
    private datosGlobales: DatosGlobales ) { }

  ngOnInit() {
    this.estaciones = [];
  }

  mostrarTabla(){
    this.loading = true;
    this.listadoRespuestasAlUsuarioService.obtenerRespuestasEntregadasAlUsuario(this.idUsuario)
    .subscribe(res => {
      this.respuestas = res;
      this.usuarioEncontrado = true;
      if(this.respuestas != null){
        this.estaciones = this.respuestas.map(respuesta => respuesta.estaciones
        .map(estacion => estacion.name));
        this.loading = false;
      }
    }, error => {
      this.mensajeError(error.error.mensaje);
      this.loading = false;
    });
  }

  mensajeError(mensaje: String){
    swal({
      type: 'error',
      title: 'Error!!',
      text: <string>mensaje
    })
  }
}
