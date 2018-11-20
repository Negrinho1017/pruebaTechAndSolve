import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ListadoRespuestasAlUsuarioComponent } from './listado-respuestas-al-usuario/listado-respuestas-al-usuario.component';

const routes: Routes = [
  { path: 'respuestas-usuario', component: ListadoRespuestasAlUsuarioComponent }
]
@NgModule({
  imports: [
    CommonModule, RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
