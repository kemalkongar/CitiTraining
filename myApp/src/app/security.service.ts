import { Injectable } from '@angular/core';
import { Security } from './security';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import{ GlobalConstants } from './global-constants';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/timeout';
import { map } from 'rxjs/operators';
import { timeout } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {

  private getAllUrl: string; 
  private requestMapping='api/securities/';
  tmp:Observable<Security[]>;
  constructor(private http: HttpClient) {
    this.getAllUrl = GlobalConstants.baseURL+this.requestMapping;  
  }

  public findAll(){
    console.log("theres findall");
  //   console.log("theres");
    this.http?.get('http://localhost:8080/api/securities/').subscribe((data) => {
      console.log(data);
      console.log('from the service class');
  }, error => {
    console.log('error');
  });

    // return this.tmp.pipe(timeout(5000)).subscribe(result => {
    //   console.log("theres");
    // });
  }

  // we don't ever save a security or a ticker
  // public save(s: Security): Observable<Object> {
  //   return this.http.post<Security>(this.addUrl, s);
  // }

}