import { Component, OnInit,Input } from '@angular/core';
import { Order } from '../order';
import { OrderService } from '../order.service';
@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  @Input()
  myOrders!: Order[];
  orderService: OrderService;


  ngOnInit(): void {

  }

}
