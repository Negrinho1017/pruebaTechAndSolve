import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { ListadoRespuestasAlUsuarioComponent } from './listado-respuestas-al-usuario/listado-respuestas-al-usuario.component';
import { AppRoutingModule } from './/app-routing.module';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { PaginaPrincipalComponent } from './pagina-principal/pagina-principal.component';
import { DatosGlobales } from './datosGlobales';
import { ConsultasComponent } from './consultas/consultas.component';
import { PaginaInicialComponent } from './pagina-inicial/pagina-inicial.component';
import { NgxLoadingModule } from 'ngx-loading';

@NgModule({
  declarations: [
    AppComponent,
    ListadoRespuestasAlUsuarioComponent,
    PaginaPrincipalComponent,
    ConsultasComponent,
    PaginaInicialComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    HttpModule,
    NgxLoadingModule
  ],
  providers: [DatosGlobales],
  bootstrap: [AppComponent]
})
export class AppModule { }
