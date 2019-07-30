import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistrationComponent } from './_components/registration/registration.component'
import { LoginComponent } from './_components/login/login.component';
import { AppComponent } from './app.component';
import { UserRegistrationComponent } from './_components/user-registration/user-registration.component';
import { DashboardComponent } from './_components/dashboard/dashboard.component';
import { AuthGuard } from './guards/auth-guard';


const routes: Routes = [
  {
    path: 'registration',
    component: RegistrationComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'userRegisteration',
    component: UserRegistrationComponent
  },
  {
    path: 'dashboard',
    canActivate : [AuthGuard],
    component: DashboardComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
