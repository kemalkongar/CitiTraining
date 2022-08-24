import { Component, OnInit } from '@angular/core';
import { OrderQueue } from '../order-queue';
import { OrderQueueService } from '../order-queue.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-order-queue-list',
  templateUrl: './order-queue-list.component.html',
  styleUrls: ['./order-queue-list.component.css']
})
export class OrderQueueListComponent implements OnInit {


  myOrderQueue!: OrderQueue[];
  orderQueueService:OrderQueueService;
  constructor(private http: HttpClient) {
    this.orderQueueService = new OrderQueueService(http);
  }

  ngOnInit(): void {

  }

}
