import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Respuesta } from '../model/Respuesta';

@Injectable({
  providedIn: 'root'
})
export class ListadoRespuestasAlUsuarioService {

  private url = "http://localhost:8080";
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private options = new RequestOptions({ headers: this.headers });
  constructor(private _http: Http, private http: HttpClient) { }

  obtenerRespuestasEntregadasAlUsuario(idUsuario: String): Observable<Respuesta[]>{
    const httpOptions = {
      params: new HttpParams().set('idUsuario', <string>idUsuario)
    };
    return this.http.get<Respuesta[]>(this.url + '/respuestas-por-usuario', httpOptions);
  }
}
