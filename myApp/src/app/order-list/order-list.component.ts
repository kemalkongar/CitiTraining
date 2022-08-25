import { Component, OnInit,Input } from '@angular/core';
import { Order } from '../order';
import { OrderService } from '../order.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  myOrders!: Order[];
  orderService: OrderService;
  constructor(private http: HttpClient) {
    this.orderService = new OrderService(http);
  }


  ngOnInit(): void {
      this.orderService?.findAll().subscribe((data) => {
        this.myOrders = data;
    }, error => {
      console.log('error');
    });
  }

}
