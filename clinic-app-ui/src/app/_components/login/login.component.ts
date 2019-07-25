import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/_services/authentication.service';
import { Router } from '@angular/router';
import { Route } from '@angular/compiler/src/core';
import { AlertService } from 'src/app/_services/alert.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  email = '';
  password = '';
  invalid = false;

  constructor( private router: Router,
               private authService: AuthenticationService,
               private alertService: AlertService
    ) {}

  ngOnInit() {
  }

  login() {
    //console.log("I am here");
    (this.authService.authenticate(this.email, this.password).subscribe(
      data => {
        console.log(data);
        this.alertService.success(data['username'], true);
        this.router.navigate(['/dashboard'])

        
      },
      error => {
        this.invalid = true;
      }
    )
    );
  }
}
