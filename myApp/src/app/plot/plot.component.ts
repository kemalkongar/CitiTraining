import { Component, OnInit,Input } from '@angular/core';
import { Security } from '../security';
import { SecurityService } from '../security.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-plot',
  templateUrl: './plot.component.html',
  styleUrls: ['./plot.component.css']
})
export class PlotComponent implements OnInit {
  mySecurities!: Security[];
  securityService: SecurityService;
  
  constructor(private http: HttpClient) {
    this.securityService = new SecurityService(http);
  }

  ngOnInit(): void {

    this.securityService?.findAll().subscribe((data) => {
      console.log(data);
      this.mySecurities = data;
  }, error => {
    console.log('error');
  });
}}

