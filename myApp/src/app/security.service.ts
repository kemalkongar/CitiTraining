import { Injectable } from '@angular/core';
import { Security } from './security';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})


export class SecurityService {

  private getAllUrl: string; 
  private addUrl: string;

  constructor(private http: HttpClient) {
    // we're not accessing getAllUrl in the final application since securities along with other
    // entities are squzzed in one page. This is just for testing
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
