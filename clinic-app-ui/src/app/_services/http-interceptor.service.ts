import { Injectable } from '@angular/core';
import { HttpClient, HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';

@Injectable({ providedIn: 'root'})
export class HttpInterceptorService implements HttpInterceptor {
    constructor ( private httpClient: HttpClient){}

    intercept(req: HttpRequest<any>, next: HttpHandler) {

        if (sessionStorage.getItem('email') && sessionStorage.getItem('token')) {
            req = req.clone ({
                setHeaders: {
                    Authorization: sessionStorage.getItem('token')
                }
            });
        }
        return next.handle(req);
    }
}
