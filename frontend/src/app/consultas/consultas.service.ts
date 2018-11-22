import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DatosUsuario } from '../model/DatosUsuario';
import { Usuario } from '../model/Usuario';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class ConsultasService {

  
  private url = "http://localhost:8080";
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private options = new RequestOptions({ headers: this.headers });
  constructor(private _http: Http, private http: HttpClient) { }

  obtenerDatosUsuario(estacionOrigen: number, estacionDestino: number): Observable<DatosUsuario>{
    return this.http.get<DatosUsuario>(this.url + '/consultas/datos-usuario?estacionOrigen='
    +estacionOrigen+'&estacionDestino='+estacionDestino);
  }

  crearRespuesta(usuario: Usuario, estacionOrigen: number, estacionDestino: number) {
    return this.http.post(this.url + '/consultas/creacion-respuesta/'+estacionOrigen+'/'+estacionDestino,
    usuario, httpOptions);
  }
}
