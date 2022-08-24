import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import{ GlobalConstants } from './global-constants';
import { OrderQueue } from './order-queue';

@Injectable({
  providedIn: 'root'
})
export class OrderQueueService {

  private getAllUrl: string; 
  private requestMapping='api/orders/queue';
  
  constructor(private http: HttpClient) {
    this.getAllUrl = GlobalConstants.baseURL+this.requestMapping;  
  }

  public findAll():Observable<OrderQueue[]>{
    return this.http?.get<OrderQueue[]>(this.getAllUrl);
  }

}
