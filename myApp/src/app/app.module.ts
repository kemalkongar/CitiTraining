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
import { IgxLegendModule, IgxCategoryChartModule } from 'igniteui-angular-charts';
import { CommonModule } from "@angular/common";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgChartsModule } from 'ng2-charts';

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
    ReactiveFormsModule,
    RouterTestingModule,
    BrowserModule, 
    BrowserAnimationsModule,
    CommonModule,
    IgxLegendModule,
    IgxCategoryChartModule,
    HttpClientModule, 
    Ng2SearchPipeModule, 
    FormsModule,
    Ng2SmartTableModule,
    NgChartsModule
  ],
  providers: [SecurityListComponent, SecurityService],
  bootstrap: [AppComponent]
})
export class AppModule { }
