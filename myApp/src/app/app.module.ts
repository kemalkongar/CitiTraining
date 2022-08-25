import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SecurityListComponent } from './security-list/security-list.component';
import { OrderListComponent } from './order-list/order-list.component';
import { OrderQueueListComponent } from './order-queue-list/order-queue-list.component';
import { HoldingsListComponent } from './holdings-list/holdings-list.component';
import { OrderFormComponent } from './order-form/order-form.component';

import { PlotComponent } from './plot/plot.component';
import { SecurityService } from './security.service';
import { HttpClientModule } from '@angular/common/http';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from "@angular/router/testing";

@NgModule({
  declarations: [
    AppComponent,
    SecurityListComponent,
    OrderListComponent,
    OrderQueueListComponent,
    HoldingsListComponent,
    OrderFormComponent,
    PlotComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, Ng2SearchPipeModule,
    Ng2SmartTableModule, FormsModule, ReactiveFormsModule,
    RouterTestingModule

  ],
  providers: [SecurityListComponent, SecurityService],
  bootstrap: [AppComponent]
})
export class AppModule { }
