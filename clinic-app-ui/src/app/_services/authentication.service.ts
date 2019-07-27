import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHelperService } from './http-helper.service';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root'})
export class AuthenticationService {
    apiRoot: string = environment.apiRoot;
    constructor(
        private http: HttpClient,
        private httpHelperService: HttpHelperService
        ) { }

        authenticate(email: string, password: string) {
            return this.httpHelperService.post(`${this.apiRoot}/user/login`, {email, password})
                .pipe(map(
                    data => {
                        sessionStorage.setItem('email', email);
                        let token = 'Bearer '+data.jwt;
                        sessionStorage.setItem('token', token);
                        return data;
                    }
                ));
        }

        isUserLoggedIn() {
            const user = sessionStorage.getItem('email');
            console.log(user);
            return !(user === null);
        }

        logout() {
            sessionStorage.removeItem('email');
        }

}