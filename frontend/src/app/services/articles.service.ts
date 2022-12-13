import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Article } from '../models/article.model';

@Injectable({
  providedIn: 'root'
})
export class ArticlesService {

 url = environment.api_url + '/resource-server';
 //url = environment.resource_url;
 constructor(private http: HttpClient){}

 getPublicArticles(): Observable<Article[]>{
  return this.http.get<Article[]>(this.url + '/api/public/articles');
 }

 getArticles(): Observable<Article[]>{
  return this.http.get<Article[]>(this.url + '/articles');
 }

}
