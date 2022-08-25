import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { OrderService } from '../order.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-order-queue-list',
  template: `
  <ng2-smart-table [settings]="settings" [source]="myOrderQueue"></ng2-smart-table>
  `,
  styleUrls: ['./order-queue-list.component.css']
})
export class OrderQueueListComponent implements OnInit {


  myOrderQueue!: Order[];
  orderService:OrderService;

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
      securityName: {
        title: 'Ticker',
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
    this.orderService?.findQueueAll().subscribe((data:any) => {
      this.myOrderQueue = data;
  }, (error:any) => {
    console.log('error');
  });

  }

}
