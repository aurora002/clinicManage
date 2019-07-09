import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistrationComponent } from './_components/registration/registration.component'
import { LoginComponent } from './_components/login/login.component';
import { AppComponent } from './app.component';
import { UserRegistrationComponent } from './_components/user-registration/user-registration.component';


const routes: Routes = [
  
  {
    path: 'registration',
    component: RegistrationComponent
  },
  {
    path:'login',
    component: LoginComponent
  },
  {
    path:'userRegisteration',
    component: UserRegistrationComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }