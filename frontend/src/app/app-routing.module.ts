import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ListadoRespuestasAlUsuarioComponent } from './listado-respuestas-al-usuario/listado-respuestas-al-usuario.component';
import { PaginaPrincipalComponent } from './pagina-principal/pagina-principal.component';
import { ConsultasComponent } from './consultas/consultas.component';
import { PaginaInicialComponent } from './pagina-inicial/pagina-inicial.component';

const routes: Routes = [
  { path: 'respuestas-usuario', component: ListadoRespuestasAlUsuarioComponent },
  { path: 'consultas', component: ConsultasComponent },
  { path: 'pagina-inicial', component: PaginaInicialComponent },
  { path: '', component: PaginaPrincipalComponent }
]
@NgModule({
  imports: [
    CommonModule, RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
