import { Component, OnInit,Input } from '@angular/core';
import { Security } from '../security';
import { SecurityService } from '../security.service';


@Component({
  selector: 'app-security-list',
  templateUrl: './security-list.component.html',
  styleUrls: ['./security-list.component.css']
})
export class SecurityListComponent implements OnInit {

  mySecurities!: Security[];
  securityService:SecurityService;

  
  // constructor(private securityService: SecurityService) {
  // }
  
  constructor(){}
  ngOnInit(): void {
    // dummy data for proof of concept
    // this.mySecurities = [
    //   new Security(3,'a','apple',10),
    //   new Security(9,'b','Citi',140),
    // ];

    // needs to be replaced by:
    this.securityService.findAll().subscribe((data:any) => {
      this.mySecurities = data;
    });
  }

}
