import { Component, OnInit,Input } from '@angular/core';
import { Security } from '../security';
import { SecurityService } from '../security.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Ng2SmartTableModule } from 'ng2-smart-table';
// import { ThrowStmt } from '@angular/compiler';


@Component({
  selector: 'app-security-list',
  // templateUrl: './security-list.component.html',
  template: `
  <ng2-smart-table [settings]="settings" [source]="tableData"></ng2-smart-table>
  `,
  styleUrls: ['./security-list.component.css']
})
export class SecurityListComponent implements OnInit {

  mySecurities!: Security[];
  securityService:SecurityService;

  settings = {
    columns: {
      ticker: {
        title: 'Ticker'
      },
      name: {
        title: 'Company Name'
      },
      price: {
        title: 'Market Price'
      }
    }
  };
  tableData = [];

  
  // constructor(private securityService: SecurityService) {
  // }
  
    constructor(private http: HttpClient) {
    this.securityService = new SecurityService(http);
  }

  ngOnInit(): void {

    this.securityService?.findAll().subscribe((data) => {
      this.mySecurities = data;

  }, error => {
    console.log('error');
  });

}}
