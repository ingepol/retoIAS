import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { from } from 'rxjs';
import { map } from 'rxjs/operators';
import { GLOBAL } from './global';

@Injectable()
export class ZoneService{
    public url:string;

    constructor(
        public _http: Http
    ){
        this.url = GLOBAL.url;
    }

    getZones(){
        return this._http.get(this.url+'zones')
            .pipe(map(res => res.json()));
    }

}