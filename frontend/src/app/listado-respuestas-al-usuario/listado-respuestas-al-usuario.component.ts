import { Component, OnInit } from '@angular/core';
import { Respuesta } from '../model/Respuesta';
import { ListadoRespuestasAlUsuarioService } from './listado-respuestas-al-usuario.service';
import swal from 'sweetalert2'

@Component({
  selector: 'app-listado-respuestas-al-usuario',
  templateUrl: './listado-respuestas-al-usuario.component.html',
  styleUrls: ['./listado-respuestas-al-usuario.component.css']
})
export class ListadoRespuestasAlUsuarioComponent implements OnInit {
  respuestas: Respuesta[];
  idUsuario: String;
  estaciones: String[];
  usuarioEncontrado: boolean = false;
  constructor( private listadoRespuestasAlUsuarioService: ListadoRespuestasAlUsuarioService ) { }

  ngOnInit() {
    this.estaciones = [];
  }

  mostrarTabla(){
    this.listadoRespuestasAlUsuarioService.obtenerRespuestasEntregadasAlUsuario(this.idUsuario)
    .subscribe(res => {
      this.respuestas = res;
      this.usuarioEncontrado = true;
    }, error => {
      this.mensajeError(error.error.mensaje);
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
