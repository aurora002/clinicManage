

import { HttpParams } from '@angular/common/http';

export class ApiHelper {

    private static notEmpty(data) {
        if ( (data || data == 0) && data !== "" && !this.isNaNVal(data)) {
            return true;
        }
    }

    private static isNaNVal(val){
        if(val){
            if(val == NaN || val === 'NaN')return true;
        }
        return false;
    }

    //ng7
    //public static extractUrlParam(urlParam: URLSearchParams, ...obj: any[]) {
    public static extractUrlParam(params: HttpParams, ...obj: any[]) {
        let arrayObj = obj;

        for (let item in arrayObj) {//for each object in the array
            for (let prop in arrayObj[item]) {//for each prop of object
                let objItem = arrayObj[item];
                let propName = String(prop);
                let propVal = objItem[prop];
               
                if (ApiHelper.notEmpty(propVal)) {
                    propVal = String(objItem[prop]);
                    params=params.set(propName, propVal);    // assign to params     
                    // console.log(prop + " " + propVal);
                }
            }
        }    
        return params;
    }

    static filterDeleted(item){
        return item.isDeleted !== true;
    }
 
    
    // static getReqOption(sortByField, offset = 0, limit = 0):ReqOption{
    //   let reqOption:ReqOption = {offset:offset, limit:limit, sortBy:sortByField};
    //   return reqOption;
    // }
}