import { Injectable }    from '@angular/core';
import { Headers, Http, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class BaseHttpService  {

public baseUrl: "http://localhost:8092";

constructor(private http: Http){}

public GetCall<T>(url : string):Promise<T>{
    debugger
    url = "http://localhost:8092/"+ url;
     return this.http.get(url).toPromise()
    .then(i => <T>i.json())
    .catch(this.handleError);
}

PostCall<T>(url: string, data: any,config:any): Promise<any> {
    url = "http://localhost:8092/"+ url;
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });     
    return this.http.post(url, data, options)
    .toPromise()
    .then(i=> i.json())
    .catch(this.handleError)
} 

PutCall<T> (url : string,data : any, config : any): Promise<T> {
    url = "http://localhost:8092/"+ url;
    return this.http.put(url, data, config)
    .toPromise()
    .then(i=> i.json())
    .catch(this.handleError)
}

DeleteCall<T>(url: string, data: any, config: any){
    url = "http://localhost:8092/"+ url;
    return this.http.delete(url)
    .toPromise()
    .then(i=> i.json())
    .catch(this.handleError)
}

private handleError (error:   any) {
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Promise.reject(errMsg);
  }
}
