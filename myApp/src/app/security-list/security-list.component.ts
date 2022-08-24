import { Component, OnInit } from '@angular/core';
import { Security } from '../security';
import { SecurityService } from '../security.service';
@Component({
  selector: 'app-security-list',
  templateUrl: './security-list.component.html',
  styleUrls: ['./security-list.component.css']
})
export class SecurityListComponent implements OnInit {
  mySecurities: Security[];
  constructor(private securityService: SecurityService) {
  }

  ngOnInit(): void {
    this.securityService.findAll().subscribe( (data:any) => {
      this.mySecurities = data;
    });
  }

}
