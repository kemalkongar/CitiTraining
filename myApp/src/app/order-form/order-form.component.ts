import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderService } from '../order.service';
import { Order } from '../order';
import{ GlobalConstants } from '../global-constants';
import {OrderListComponent} from '../order-list/order-list.component';
@Component({
  selector: 'app-order-form',
  templateUrl: './order-form.component.html',
  styleUrls: ['./order-form.component.css']
})
export class OrderFormComponent implements OnInit {

  order: Order;

  constructor(
    private route: ActivatedRoute, 
      private router: Router, 
        private orderService: OrderService) {
    this.order = new Order();
  }
  ngOnInit(): void {
  }

  onSubmit() {
    this.orderService.save(this.order).subscribe(result => this.refreshOrdersAndQueueTable());
  }

  refreshOrdersAndQueueTable() {
    window.location.reload();
    // console.log(this.router.navigate(["OrderListComponent"]));
    // this.router.navigateByUrl('/', {skipLocationChange: true}).then(()=>
    // this.router.navigate(["/"+this.orderService.requestMapping]));
    // this.router.navigate(["///"+this.orderService.requestMapping]);

    // this.router.navigate(["/"+this.orderService.requestMapping]));

    // this.router.navigate(["//"+this.orderService.requestMapping]);
    // this.router.navigate(["//"+this.orderService.requestMapping+"queue/"]);
    // this.router.navigateByUrl("localhost:4200/");

    // this.router.navigate([]);

  }

}
