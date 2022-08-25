import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { IgxLegendModule, IgxCategoryChartModule } from 'igniteui-angular-charts';
import { PlotComponent } from './plot.component';
@NgModule({
  declarations: [
    PlotComponent
],
imports: [
    BrowserModule,
    BrowserAnimationsModule,
    CommonModule,
    FormsModule,
    IgxLegendModule,
    IgxCategoryChartModule
],
providers: [],
entryComponents: [],
schemas: []
})
export class PlotModule { }
