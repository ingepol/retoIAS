import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { from } from 'rxjs';
import { map } from 'rxjs/operators';
import { Bird } from '../models/bird';
import { GLOBAL } from './global';

@Injectable()
export class CountryService{
    public url:string;

    constructor(
        public _http: Http
    ){
        this.url = GLOBAL.url;
    }

    getCountries(){
        return this._http.get(this.url+'countries')
            .pipe(map(res => res.json()));
    }

}
