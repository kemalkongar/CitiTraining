import { Component, OnInit,Input } from '@angular/core';
import { Security } from '../security';
import { SecurityService } from '../security.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
// import { AfterViewInit, ViewChild, ChangeDetectionStrategy, ChangeDetectorRef } from '@angular/core';


@Component({
  selector: 'app-plot',
  templateUrl: './plot.component.html',
  styleUrls: ['./plot.component.css']
})
export class PlotComponent implements OnInit {
  searchText: any;
  mySecurities!: Security[];
  securityService: SecurityService;
  myPlotSecurity: Security;

  constructor(private http: HttpClient) {
    this.securityService = new SecurityService(http);
  }

  ngOnInit(): void {
    this.securityService?.findAll().subscribe((data) => {
      this.mySecurities = data;
  }, error => {
    console.log('error');
  });

}

  // @ViewChild("legend", { static: true } )
  // private legend: IgxLegendComponent
  // @ViewChild("chart", { static: true } )
  // private chart: IgxCategoryChartComponent
  // getPlotSecurity(){
  //   this.securityService?.findByID(1).subscribe((data) => {
  //     this.myPlotSecurity=data;
  //     // this.myPlotSecurity.ticker = data.ticker;
  //     // let listPrice =[];
  //     // listPrice.push(data.t0);
  //     // listPrice.push(data.tminus1);
  //     // listPrice.push(data.tminus2);
  //     // this.myPlotSecurity.price = listPrice;
  //   }, error => {
  //   console.log('error');
  // });
  // }


}


