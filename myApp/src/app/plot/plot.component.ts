import { Component, OnInit,Input } from '@angular/core';
import { Security } from '../security';
import { SecurityService } from '../security.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AfterViewInit, ViewChild, ChangeDetectionStrategy, ChangeDetectorRef } from '@angular/core';
import { IgxLegendComponent, IgxCategoryChartComponent } from 'igniteui-angular-charts';
@Component({
  selector: 'app-plot',
  templateUrl: './plot.component.html',
  styleUrls: ['./plot.component.css']
})
export class PlotComponent implements OnInit {
  mySecurities!: Security[];
  oneSecurity!:Security [];
  securityService: SecurityService;
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

  @ViewChild("legend", { static: true } )
  private legend: IgxLegendComponent
  @ViewChild("chart", { static: true } )
  private chart: IgxCategoryChartComponent

  selectSecurity(id:number): void {
    this.securityService?.findByID(id).subscribe((data) => {
      console.log(data);
      this.oneSecurity = data;
  }, error => {
    console.log('error');
  });
}
}


