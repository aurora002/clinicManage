import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/_services/authentication.service';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';
import { PatientService } from 'src/app/_services/Patient.service';
import { Patient } from 'src/app/_models/patient';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

user = '';
patients: Patient[];

constructor(private authService: AuthenticationService,
            private router: Router,
            private patientService: PatientService) { }

ngOnInit() {
      if (this.authService.isUserLoggedIn()) {
        this.user = sessionStorage.getItem('email');
      }

      this.patientService.getAllPatients()
        .subscribe(
          data => {
            
            this.patients = data;
            console.log(this.patients);
          },
          error => {

          });
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['login']);
  }
}
