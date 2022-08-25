import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { OrderService } from '../order.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-order-queue-list',
  templateUrl: './order-queue-list.component.html',
  styleUrls: ['./order-queue-list.component.css']
})
export class OrderQueueListComponent implements OnInit {


  myOrderQueue!: Order[];
  orderService:OrderService;
  constructor(private http: HttpClient) {
    this.orderService = new OrderService(http);
  }

  ngOnInit(): void {
    this.orderService?.findQueueAll().subscribe((data:any) => {
      this.myOrderQueue = data;
  }, (error:any) => {
    console.log('error');
  });

  }

}
