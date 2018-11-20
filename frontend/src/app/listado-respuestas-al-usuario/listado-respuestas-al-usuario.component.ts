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
  constructor( private listadoRespuestasAlUsuarioService: ListadoRespuestasAlUsuarioService ) { }

  ngOnInit() {
    this.listadoRespuestasAlUsuarioService.obtenerRespuestasEntregadasAlUsuario("1017224720")
    .subscribe(res => {
      this.respuestas = res;
    }, error => 
    console.log(error));
  }

}
