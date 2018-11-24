import { Injectable } from "@angular/core";
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from "@angular/router";

@Injectable()
export class AuthGuardInSession implements CanActivate {

    constructor(private router: Router) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        if (localStorage.getItem('idUsuario') && localStorage.getItem('rol') == '2') {
            return true;
        }
        if(!localStorage.getItem('idUsuario')){
            this.router.navigate(['/'], { queryParams: { returnUrl: state.url }});
            return false;
        } 
        if (localStorage.getItem('rol') != '2'){
            localStorage.removeItem('idUsuario');
            this.router.navigate(['/'], { queryParams: { returnUrl: state.url }});
            return false;
        } 
        
    }
}