import { Injectable } from "@angular/core";
import { Usuario } from "./model/Usuario";

@Injectable()
export class DatosGlobales {
    mostrarBarra: boolean;
    usuarioActual: Usuario;
}