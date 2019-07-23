import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AlertService } from 'src/app/_services/alert.service';
import { PatientService } from 'src/app/_services/Patient.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss'],
  encapsulation: ViewEncapsulation.None,
})
export class RegistrationComponent implements OnInit {
  PatientregisterForm = new FormGroup({
    name: new FormControl(''),
    email: new FormControl(''),
    ic: new FormControl(''),
    dob: new FormControl(''),
    address: new FormControl(''),
    hp: new FormControl(''),
    gender: new FormControl(''),
    });
    loading = false;
    submitted = false;
  
    constructor(
      private formBuilder: FormBuilder,
      private router: Router,
      // private authenticationService: AuthenticationService,
      private patientService: PatientService,
      private alertService: AlertService,
  
    ) { }
    ngOnInit() {
      this.PatientregisterForm = this.formBuilder.group({      
          name: ['', Validators.required],
          address:['',Validators.required],
          ic:[''],
          hp:[''],
          gender:[''],
          dob:[''],
          email:[''],
      });
    }

    onSubmit() {
      this.submitted = true;
  
      // stop here if form is invalid
      if (this.PatientregisterForm.invalid) {
          return;
      }
  
      this.loading = true;
      console.log(this.PatientregisterForm.value);
      this.patientService.registerPatient(this.PatientregisterForm.value)
          // .pipe(first())
          .subscribe(
              data => {
                  this.alertService.success('Registration successful', true);
                  // this.router.navigate(['/login']);
              },
              error => {
                  this.alertService.error(error);
                  this.loading = false;
              });
  }
  

}
