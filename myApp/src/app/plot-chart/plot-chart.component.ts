import { AfterViewInit, Component, ViewChild, ChangeDetectionStrategy, ChangeDetectorRef } from '@angular/core';
import { SecurityService } from '../security.service';
import { Security } from '../security';
import { DayPrice, DayPriceItem } from './DayPrice';
import { IgxCategoryChartComponent } from 'igniteui-angular-charts';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-plot-chart',
  templateUrl: './plot-chart.component.html',
  styleUrls: ['./plot-chart.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})

export class PlotChartComponent{
  securityService:SecurityService;
  myDayPrice:DayPrice;
  mySecurity:Security;

  // public constructor(private _detector: ChangeDetectorRef) {

  // }  
  constructor(private http: HttpClient) {
    this.securityService = new SecurityService(http);
  }
    @ViewChild("chart", { static: true } )
    private chart: IgxCategoryChartComponent

    private _dayPrice!: DayPrice;
    public get dayPrice(): DayPrice {

    //should return a security, need to transform into DayPrice obj
      this.securityService?.findByID(1).subscribe((data) => {
        this.mySecurity = data;
    }, error => {
      console.log('error');
    });


        if (this._dayPrice == null)
        {
            this._dayPrice = new DayPrice();
        }
        return this._dayPrice;
    }


  }

