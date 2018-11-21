import { Component } from '@angular/core';
import { DatosGlobales } from './datosGlobales';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
  mostrarBarra = this.datosGlobales.mostrarBarra;

  constructor(private datosGlobales: DatosGlobales) { }
}
