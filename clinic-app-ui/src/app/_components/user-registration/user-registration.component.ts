import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, NgForm, FormControl } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AlertService   } from '../../_services/alert.service';
import { UserService } from 'src/app/_services/user.service';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.scss']
})
export class UserRegistrationComponent implements OnInit {
  registerForm = new FormGroup({
  username: new FormControl(''),
  email: new FormControl(''),
  password: new FormControl(''),

  });

  // registerForm: FormGroup; 
  // username:string=''; 
  // email:string='';
  // password:string='';
 

  loading = false;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    // private authenticationService: AuthenticationService,
    private userService: UserService,
    private alertService: AlertService,

  ) { }
  ngOnInit() {
    this.registerForm = this.formBuilder.group({      
        username: ['', Validators.required],
        email: ['', Validators.required],
        password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.registerForm.invalid) {
        return;
    }

    this.loading = true;
    console.log(this.registerForm.value);
    this.userService.register(this.registerForm.value)
        .pipe(first())
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