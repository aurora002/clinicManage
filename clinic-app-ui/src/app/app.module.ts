import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlertComponent } from './_components/alert/alert.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RegistrationComponent } from './_components/registration/registration.component';
// app/app.module.ts
import { MyMaterialModule } from './material.module';
import { LoginComponent } from './_components/login/login.component';
import { ReactiveFormsModule }    from '@angular/forms';
import { UserRegistrationComponent } from './_components/user-registration/user-registration.component';
import { AlertService } from './_services/alert.service';
import { UserService } from './_services/user.service';
import { HttpHelperService } from './_services/http-helper.service';


@NgModule({
  declarations: [
    AppComponent,
    AlertComponent,
    RegistrationComponent,
    LoginComponent,
    UserRegistrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MyMaterialModule,
    ReactiveFormsModule,
    HttpClientModule,   

  ],
  providers: [
    HttpHelperService,
    AlertService,
    UserService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }