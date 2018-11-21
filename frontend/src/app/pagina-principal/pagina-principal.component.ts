import { Component, OnInit } from '@angular/core';
import { DatosGlobales } from '../datosGlobales';

@Component({
  selector: 'app-pagina-principal',
  templateUrl: './pagina-principal.component.html',
  styleUrls: ['./pagina-principal.component.css']
})
export class PaginaPrincipalComponent implements OnInit {
  usuario: String;
  identificacion: String;

  constructor( private datosGlobales: DatosGlobales ) { }

  ngOnInit() {
    this.datosGlobales.mostrarBarra = false;
  }

}
