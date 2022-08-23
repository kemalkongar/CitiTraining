import { Injectable } from '@angular/core';
import { Security } from './security';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})


export class SecurityService {

  private url: string;
  constructor(private http: HttpClient) {
    this.getAllUrl = 'http://localhost:8080/api/securities';
    this.addUrl = 'http://localhost:8080/api/securities/addSecurity';

  }

  public findAll(): Observable<Security[]> {
    return this.http.get<Security[]>(this.getAllUrl);
  }

  public save(s: Security) {
    return this.http.post<Security>(this.addUrl, s);
  }
}
