import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHelperService } from './http-helper.service';
import { HttpParams } from '@angular/common/http';
import { ApiHelper } from '../util/api-helper.util';

import { User } from '../_models/user';
import { environment } from 'src/environments/environment';


@Injectable({ providedIn: 'root' })
export class UserService {

    apiRoot: string = environment.apiRoot;
    
    constructor(
        private http: HttpClient,
        private httpHelperService: HttpHelperService        
        ) { }


    register(user: User) {
        let urlParam = new HttpParams();
        urlParam = ApiHelper.extractUrlParam(urlParam);
        return this.httpHelperService.get(`${this.apiRoot}/users/register`,user);
    }

   



}