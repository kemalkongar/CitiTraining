import { AfterViewInit, Component, ViewChild, ChangeDetectionStrategy, ChangeDetectorRef } from '@angular/core';
import { DayPrice, DayPriceItem } from './DayPrice';
import { IgxCategoryChartComponent } from 'igniteui-angular-charts';

@Component({
  selector: 'app-plot-chart',
  templateUrl: './plot-chart.component.html',
  styleUrls: ['./plot-chart.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})

export class PlotChartComponent{


  public constructor(private _detector: ChangeDetectorRef) {

  }  

    @ViewChild("chart", { static: true } )
    private chart: IgxCategoryChartComponent
    private _dayPrice!: DayPrice;
    public get dayPrice(): DayPrice {

    //should return a security, need to transform into DayPrice obj



        if (this._dayPrice == null)
        {
          console.log("getting data");
          // this._dayPrice = new DayPrice();
        }
        return this._dayPrice;
    }


  }

