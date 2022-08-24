import { Component, OnInit,Input } from '@angular/core';
// import { Order } from '../order';
import { OrderQueue } from '../order-queue';
import { OrderQueueService } from '../order-queue.service';

@Component({
  selector: 'app-order-queue-list',
  templateUrl: './order-queue-list.component.html',
  styleUrls: ['./order-queue-list.component.css']
})
export class OrderQueueListComponent implements OnInit {


  myOrderQueue!: OrderQueue[];
  orderQueueService:OrderQueueService;


  ngOnInit(): void {

  }

}
