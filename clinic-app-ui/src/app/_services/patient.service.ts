import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHelperService } from './http-helper.service';
import { HttpParams } from '@angular/common/http';
import { ApiHelper } from '../util/api-helper.util';

import { Patient } from '../_models/patient';
import { environment } from 'src/environments/environment';


@Injectable({ providedIn: 'root' })
export class PatientService {

    apiRoot: string = environment.apiRoot;
    
    constructor(
        private http: HttpClient,
        private httpHelperService: HttpHelperService        
        ) { }


    registerPatient(patient: Patient) {
        let urlParam = new HttpParams();
        urlParam = ApiHelper.extractUrlParam(urlParam);
        return this.httpHelperService.get(`${this.apiRoot}/patient/register`,patient);
    }

   



}