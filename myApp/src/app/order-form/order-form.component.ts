import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderService } from '../order.service';
import { Order } from '../order';

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
    this.router.navigate([this.orderService.getAllUrl]);
    this.router.navigate([this.orderService.getQueueUrl]);

  }

}
