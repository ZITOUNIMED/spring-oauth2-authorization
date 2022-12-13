import { HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class AppHttpInterceptor implements HttpInterceptor{
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<any> {
        const token = sessionStorage.getItem('token') as string;
        return next.handle(req.clone({setHeaders:{'Authorization': `Bearer ${token}`} }));
        //return next.handle(req.clone());
    }
}