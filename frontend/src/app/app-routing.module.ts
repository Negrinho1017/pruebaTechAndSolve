import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ListadoRespuestasAlUsuarioComponent } from './listado-respuestas-al-usuario/listado-respuestas-al-usuario.component';
import { PaginaPrincipalComponent } from './pagina-principal/pagina-principal.component';
import { ConsultasComponent } from './consultas/consultas.component';
import { PaginaInicialComponent } from './pagina-inicial/pagina-inicial.component';
import { AuthGuard } from './AuthGuard';

const routes: Routes = [
  { path: 'respuestas-usuario', component: ListadoRespuestasAlUsuarioComponent, canActivate: [AuthGuard] },
  { path: 'consultas', component: ConsultasComponent, canActivate: [AuthGuard] },
  { path: 'pagina-inicial', component: PaginaInicialComponent, canActivate: [AuthGuard] },
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
