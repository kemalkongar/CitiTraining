import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SecurityListComponent } from './security-list/security-list.component';
import { OrderListComponent } from './order-list/order-list.component';
import { OrderQueueListComponent } from './order-queue-list/order-queue-list.component';
import { HoldingsListComponent } from './holdings-list/holdings-list.component';

import {AppRoutingModule} from './app-routing'
const routes: Routes = [
  { path: '/api/securities/', component: SecurityListComponent},
  {path: '/api/orders/', component: OrderListComponent},
  {path: 'api/orders/queue/', component:OrderQueueListComponent},
  {path: 'api/holdings/', component: HoldingsListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }