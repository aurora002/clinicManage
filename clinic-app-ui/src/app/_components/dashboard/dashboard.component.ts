import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/_services/authentication.service';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

user = '';

constructor(private authService: AuthenticationService,
            private router: Router) { }

ngOnInit() {
      if (this.authService.isUserLoggedIn()) {
        this.user = sessionStorage.getItem('email');
      }
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['login']);
  }
}
