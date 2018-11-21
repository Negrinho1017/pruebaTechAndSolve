import { Component, OnInit } from '@angular/core';
import { DatosGlobales } from '../datosGlobales';

@Component({
  selector: 'app-pagina-inicial',
  templateUrl: './pagina-inicial.component.html',
  styleUrls: ['./pagina-inicial.component.css']
})
export class PaginaInicialComponent implements OnInit {

  mostrarBarra = this.datosGlobales.mostrarBarra;
  usuarioActual = this.datosGlobales.usuarioActual;

  constructor(private datosGlobales: DatosGlobales) { }

  ngOnInit() {
  }

}
