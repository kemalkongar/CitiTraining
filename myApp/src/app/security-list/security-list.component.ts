import { Component, OnInit,Input } from '@angular/core';
import { Security } from '../security';
import { SecurityService } from '../security.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
// import { ThrowStmt } from '@angular/compiler';


@Component({
  selector: 'app-security-list',
  template: `
  <ng2-smart-table [settings]="settings" [source]="mySecurities"></ng2-smart-table>
  `,
  styleUrls: ['./security-list.component.css']
})
export class SecurityListComponent implements OnInit {

  mySecurities!: Security[];
  securityService:SecurityService;

  settings = {
    actions: {
      delete: false,
      add: false,
      edit: false,
    },
    columns: {
      ticker: {
        title: 'Ticker',
        editable: false,
        addable: false,
      },
      name: {
        title: 'Company Name',
        editable: false,
        addable: false
      },
      t0: {
        title: 'Market Price',
        editable: false,
        addable: false
      }
    },
  };


  
  // constructor(private securityService: SecurityService) {
  // }
  
    constructor(private http: HttpClient) {
    this.securityService = new SecurityService(http);
  }

  ngOnInit(): void {
    // dummy data for proof of concept
    // this.mySecurities = [
    //   new Security(3,'a','apple',10),
    //   new Security(9,'b','Citi',140),
    // ];

    this.securityService?.findAll().subscribe((data) => {
      this.mySecurities = data;

  }, error => {
    console.log('error');
  });

}}
