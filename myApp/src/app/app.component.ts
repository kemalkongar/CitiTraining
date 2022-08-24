import { Component } from '@angular/core';
import { Security } from './security';
import { SecurityListComponent } from './security-list/security-list.component';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  tickers: Security[];

  title = 'my training project';


  constructor() {
    this.tickers = [
      new Security()
    ];   
   }

}
