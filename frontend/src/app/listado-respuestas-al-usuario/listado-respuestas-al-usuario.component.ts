import { Component, OnInit } from '@angular/core';
import { Respuesta } from '../model/Respuesta';
import { ListadoRespuestasAlUsuarioService } from './listado-respuestas-al-usuario.service';

@Component({
  selector: 'app-listado-respuestas-al-usuario',
  templateUrl: './listado-respuestas-al-usuario.component.html',
  styleUrls: ['./listado-respuestas-al-usuario.component.css']
})
export class ListadoRespuestasAlUsuarioComponent implements OnInit {
  respuestas: Respuesta[];
  idEvaluado: String;
  usuarioEncontrado: boolean = false;
  constructor( private listadoRespuestasAlUsuarioService: ListadoRespuestasAlUsuarioService ) { }

  ngOnInit() {
  }

  mostrarTabla(){
    this.listadoRespuestasAlUsuarioService.obtenerRespuestasEntregadasAlUsuario(this.idEvaluado)
    .subscribe(res => {
      this.respuestas = res;
      this.usuarioEncontrado = true;
    }, error => 
    console.log(error));
  }

}
