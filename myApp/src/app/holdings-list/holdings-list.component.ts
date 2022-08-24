import { Component, OnInit,Input } from '@angular/core';
import { Holdings } from '../holdings';
import { HoldingsService } from '../holdings.service';

@Component({
  selector: 'app-holdings-list',
  templateUrl: './holdings-list.component.html',
  styleUrls: ['./holdings-list.component.css']
})
export class HoldingsListComponent implements OnInit {

  myHoldings!: Holdings[];
  holdingService: HoldingsService;


  ngOnInit(): void {

  }

}
