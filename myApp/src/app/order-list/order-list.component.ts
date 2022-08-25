import { Component, OnInit,Input } from '@angular/core';
import { Order } from '../order';
import { OrderService } from '../order.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-order-list',
  template: `
  <ng2-smart-table [settings]="settings" [source]="myOrders"></ng2-smart-table>
  `,
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  myOrders!: Order[];
  orderService: OrderService;

  settings = {
    actions: {
      delete: false,
      add: false,
      edit: false,
    },
    columns: {
      orderType: {
        title: 'Order Type',
        editable: false,
        addable: false,
      },
      id: {
        title: 'Id',
        editable: false,
        addable: false
      },
      executePrice: {
        title: 'Execute Price',
        editable: false,
        addable: false
      },
      quantity: {
        title: "Quantity",
        editable: false,
        addable: false
      },
      orderStatus: {
        title: "Status",
        editable: false,
        addable: false
      }
    },
  };


  constructor(private http: HttpClient) {
    this.orderService = new OrderService(http);
  }


  ngOnInit(): void {
      this.orderService?.findAll().subscribe((data) => {
        this.myOrders = data;
        console.log(this.myOrders);
    }, error => {
      console.log('error');
    });
  }

}
