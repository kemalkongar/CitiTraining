import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import{ GlobalConstants } from './global-constants';
import { Order } from './order';


@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private getAllUrl: string; 
  private addUrl: string;
  private requestMapping='api/orders/';
  
  constructor(private http: HttpClient) {
    this.getAllUrl = GlobalConstants.baseURL+this.requestMapping;  
    this.addUrl = GlobalConstants.baseURL+this.requestMapping+"/addOrder";
  }

  public findAll():Observable<Order[]>{
    return this.http?.get<Order[]>(this.getAllUrl);
  }

  public save(o: Order) {
    return this.http.post<Order>(this.addUrl, o);
  }
}
