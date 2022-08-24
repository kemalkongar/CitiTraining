import { Component, OnInit,Input } from '@angular/core';
import { Security } from '../security';
import { SecurityService } from '../security.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
// import { ThrowStmt } from '@angular/compiler';


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
      console.log(data);
      this.mySecurities = data;
  }, error => {
    console.log('error');
  });

}}
