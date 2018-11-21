import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../model/Usuario';

@Injectable({
  providedIn: 'root'
})
export class PaginaPrincipalService {
  private url = "http://localhost:8080";
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private options = new RequestOptions({ headers: this.headers });
  constructor(private _http: Http, private http: HttpClient) { }

  ingresarAlSistema(idUsuario: String, nombreUsuario: String): Observable<Usuario>{
    const httpOptions = {
      params: 
        new HttpParams()
        .set('idUsuario', <string> idUsuario)
        .set('nombreUsuario', <string> nombreUsuario)
    };
    return this.http.get<Usuario>(this.url + '/ingreso-al-sistema', httpOptions);
  }
}
