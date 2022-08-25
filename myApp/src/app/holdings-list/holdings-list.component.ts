import { Component, OnInit } from '@angular/core';
import { Holdings } from '../holdings';
import { HoldingsService } from '../holdings.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-holdings-list',
  template: `
  <ng2-smart-table [settings]="settings" [source]="myHoldings"></ng2-smart-table>
  `,
  styleUrls: ['./holdings-list.component.css']
})
export class HoldingsListComponent implements OnInit {

  myHoldings!: Holdings[];
  holdingService: HoldingsService;

  settings = {
    actions: {
      delete: false,
      add: false,
      edit: false,
    },
    columns: {
      security_ticker: {
        title: 'Ticker',
        editable: false,
        addable: false,
      },
      security_name: {
        title: 'Company Name',
        editable: false,
        addable: false
      },
      buyPrice: {
        title: 'Average Price',
        editable: false,
        addable: false
      },
      lot: {
        title: "Quantity",
        editable: false,
        addable: false
      }
    },
  };

  constructor(private http: HttpClient) {
    this.holdingService = new HoldingsService(http);
  }

  ngOnInit(): void {
    this.holdingService?.findAll().subscribe((data) => {
      this.myHoldings = data;
      }, error => {
    console.log('error');
    });
  }
}
