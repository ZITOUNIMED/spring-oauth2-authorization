import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  url = environment.api_url + "/auth";
  constructor(private http: HttpClient){}

  login(login: string, password: string): Observable<any>{
    return this.http.post(this.url + '/login', {login, password});
  }
}
