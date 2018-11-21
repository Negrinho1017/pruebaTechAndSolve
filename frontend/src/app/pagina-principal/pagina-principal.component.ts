import { Component, OnInit } from '@angular/core';
import { DatosGlobales } from '../datosGlobales';
import { PaginaPrincipalService } from './pagina-principal.service';
import swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pagina-principal',
  templateUrl: './pagina-principal.component.html',
  styleUrls: ['./pagina-principal.component.css']
})
export class PaginaPrincipalComponent implements OnInit {
  nombreUsuario: String;
  identificacion: String;
  constructor( private datosGlobales: DatosGlobales, 
  private paginaPrincipalService: PaginaPrincipalService, private router: Router ) { }

  ngOnInit() {
    this.datosGlobales.mostrarBarra = false;
  }

  ingresarAlSistema(){
    this.paginaPrincipalService.ingresarAlSistema(this.identificacion, this.nombreUsuario)
    .subscribe( res => {
      this.datosGlobales.usuarioActual = res;
      this.datosGlobales.mostrarBarra = true;
      this.router.navigate(['pagina-inicial']);
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
