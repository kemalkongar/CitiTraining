import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import{ GlobalConstants } from './global-constants';
import { Order } from './order';


@Injectable({
  providedIn: 'root'
})
export class OrderService {

  public getAllUrl: string; 
  public addUrl: string;
  public getQueueUrl: string;

  public requestMapping='api/orders/';

  constructor(private http: HttpClient) {
    this.getAllUrl = GlobalConstants.baseURL+this.requestMapping;  
    this.getQueueUrl = GlobalConstants.baseURL+this.requestMapping+"queue/";  
    this.addUrl = GlobalConstants.baseURL+this.requestMapping+"addOrder/";
  }

  public findAll():Observable<Order[]>{
    return this.http?.get<Order[]>(this.getAllUrl);
  }
  public findQueueAll():Observable<Order[]>{
    return this.http?.get<Order[]>(this.getQueueUrl);
  }
  public save(o: Order) {
    return this.http.post<Order>(this.addUrl, o);
  }
}
