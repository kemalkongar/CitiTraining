import { Component, OnInit } from '@angular/core';
import { Holdings } from '../holdings';
import { HoldingsService } from '../holdings.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-holdings-list',
  templateUrl: './holdings-list.component.html',
  styleUrls: ['./holdings-list.component.css']
})
export class HoldingsListComponent implements OnInit {

  myHoldings!: Holdings[];
  holdingService: HoldingsService;

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
