import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SecurityListComponent } from './security-list/security-list.component';
import { OrderListComponent } from './order-list/order-list.component';
import { OrderQueueListComponent } from './order-queue-list/order-queue-list.component';
import { HoldingsListComponent } from './holdings-list/holdings-list.component';
import { PlotComponent } from './plot/plot.component';
import { SecurityService } from './security.service';
import { HttpClientModule } from '@angular/common/http';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    SecurityListComponent,
    OrderListComponent,
    OrderQueueListComponent,
    HoldingsListComponent,
    PlotComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, Ng2SearchPipeModule, FormsModule,Ng2SmartTableModule
  ],
  providers: [SecurityListComponent, SecurityService],
  bootstrap: [AppComponent]
})
export class AppModule { }
