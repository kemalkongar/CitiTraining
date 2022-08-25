import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import{ GlobalConstants } from './global-constants';
import { Holdings } from './holdings';

@Injectable({
  providedIn: 'root'
})
export class HoldingsService {

  private getAllUrl: string; 
  private requestMapping='api/holdings/';
  
  constructor(private http: HttpClient) {
    this.getAllUrl = GlobalConstants.baseURL+this.requestMapping;  
  }

  public findAll():Observable<Holdings[]>{
    return this.http?.get<Holdings[]>(this.getAllUrl);
  }
}
