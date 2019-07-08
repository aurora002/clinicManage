
import {throwError as observableThrowError,  Observable } from 'rxjs';

import {catchError, map} from 'rxjs/operators';
import { User } from '../_models/user';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpResponse } from '@angular/common/http';
//import { HttpResponse } from '@angular/common/http/src/response';

@Injectable()
export class HttpHelperService {

constructor(
    private http:HttpClient
) { }

  createAuthorizationHeader(headers: HttpHeaders, token: string) {
    //headers.append('SampleHeader', token);
  }

  private getAuthToken() {
    return 'token'
  }

  private getUserName() {
    return 'userName'
  }

  private handleError(error: any) {
    console.log('handleError ',error);
    let errMsg: string;
    // if (error instanceof Response) {
    //   if(error.json().message){
    //     const body = error.json() || '';
    //     errMsg = body.message || JSON.stringify(body);
    //   } else {
    //     errMsg = `${error.status} - ${error.statusText || ''}`;
    //   }
    // } else {
      errMsg = error.error.message ? error.error.message : error.toString();
    // }
    console.error(errMsg);
    
    return observableThrowError(errMsg);
  }

  private extractData(res: any) { //change response to any
    let body;
    if (res instanceof HttpResponse) {
      body = res.body;
    } else {
      body = res;
    }
    return body || {};
  }


  get(url, param?) {
    let headers = new HttpHeaders();
    let token = this.getAuthToken();
    let userName = this.getUserName();
    const authHeader = token;

    this.createAuthorizationHeader(headers, authHeader);
    headers = headers.append('Content-Type', 'application/json');
    headers = headers.append('Cache-Control', 'no-cache');
    headers = headers.append('Cache-Control', 'no-store');
    headers = headers.append('Cache-Control', 'must-revalidate');
    headers = headers.append('If-Modified-Since', 'Mon, 26 Jul 1997 05:00:00 GMT');
    headers = headers.append('Pragma', 'no-cache');

    let options = null; 
    if (param) {
      //options = {search: param, headers: headers };
      options = { params: param, headers: headers };
    } else {
      options = { headers: headers };
    } 
    console.debug('options: ' + options);
    return this.http.get(url, options).pipe(map(this.extractData),catchError(this.handleError),);
  }



  //when the response has an empty body
  //do not use .json map, otherwise, the response object will not be returned
  post(url, data) {
    let headers = new HttpHeaders();
    let token = this.getAuthToken();
    let userName = this.getUserName();
    const authHeader = token;
    this.createAuthorizationHeader(headers, authHeader);
    headers = headers.append('Content-Type', 'application/json');
    headers = headers.append('Cache-Control', 'no-cache');
    headers = headers.append('Cache-Control', 'no-store');
    headers = headers.append('Cache-Control', 'must-revalidate');
    headers = headers.append('If-Modified-Since', 'Mon, 26 Jul 1997 05:00:00 GMT');
    headers = headers.append('Pragma', 'no-cache');


    let options = { headers: headers };

    let bodyString = '';
    if (data) bodyString = JSON.stringify(data);

    return this.http.post(url, bodyString, options).pipe(catchError(this.handleError));
    

  }
  //  @LimitAccess(WebConstant.KEY_CONSTANT_UPDATE_ACCESS)
  put(url, data) {
    let headers = new HttpHeaders();
    let token = this.getAuthToken();
    let userName = this.getUserName();
    const authHeader = token;
    this.createAuthorizationHeader(headers, authHeader);
    headers = headers.append('Content-Type', 'application/json');
    headers = headers.append('Cache-Control', 'no-cache');
    headers = headers.append('Cache-Control', 'no-store');
    headers = headers.append('Cache-Control', 'must-revalidate');
    headers = headers.append('If-Modified-Since', 'Mon, 26 Jul 1997 05:00:00 GMT');
    headers = headers.append('Pragma', 'no-cache');

    // let options = new RequestOptions({ headers: headers });
    let options = { headers: headers };

    let bodyString = '';

    if (data) bodyString = JSON.stringify(data);
    return this.http.put(url, bodyString, options).pipe(catchError(this.handleError)); 

  }
  //  @LimitAccess(WebConstant.KEY_CONSTANT_DELETE_ACCESS)
  delete(url) {
    let headers = new HttpHeaders();
    let token = this.getAuthToken();
    let userName = this.getUserName();
    const authHeader = token;
    this.createAuthorizationHeader(headers, authHeader);
    headers.append('Content-Type', 'application/json');
    headers.append('Cache-Control', 'no-cache');
    headers.append('If-Modified-Since', 'Mon, 26 Jul 1997 05:00:00 GMT');
    headers.append('Pragma', 'no-cache');

    // let options = new RequestOptions({ headers: headers });
    let options = { headers: headers };

    return this.http.delete(url, options).pipe(catchError(this.handleError));
  

  }


  uploadFile(fileList) {

    if (fileList.length > 0) {
      let file: File = fileList[0];
      let formData: FormData = new FormData();
      formData.append('uploadFile', file, file.name);
      console.log(file);
      console.log(file.name);

      let headers = new HttpHeaders();
      headers.append('Content-Type', 'multipart/form-data');
      headers.append('Accept', 'application/json');
      // let options = new RequestOptions({ headers: headers });
      let options = { headers: headers };
      return this.http.post('/api/fileUpload', formData, options).pipe(catchError(this.handleError));

    }

  }

  login(url, req:User){
    let headers = new HttpHeaders();
    let token = this.getAuthToken();
    let userName = this.getUserName();
    const authHeader = token;
    this.createAuthorizationHeader(headers, authHeader);
    headers.append('Content-Type', 'application/x-www-form-urlencoded');

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth-token'
      })
    };

    // let options = new RequestOptions({ headers: headers });
    let options = { headers: headers };

    //let bodyString = ''
    //if (req) bodyString = JSON.stringify(req);

    const bodyString = 'j_username=' + encodeURIComponent(req.username) +
            '&j_password=' + encodeURIComponent(req.password) +
            '&submit=Login';
    
    //console.log(bodyString);

    return this.http.post(url, bodyString, options).pipe(catchError(this.handleError));
  }







}