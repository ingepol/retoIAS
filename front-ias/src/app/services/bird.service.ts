import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { from } from 'rxjs';
import { map } from 'rxjs/operators';
import { Bird } from '../models/bird';
import { GLOBAL } from './global';

@Injectable()
export class BirdService{
    public url:string;

    constructor(
        public _http: Http
    ){
        this.url = GLOBAL.url;
    }

    getBirds(zoneCode:number, nameBird:string){
        let url = this.url+'birds/search/';
        if(typeof nameBird == "undefined"){
            return this._http.get( url+zoneCode)
                .pipe(map(res => res.json()));
        }
        return this._http.get(url+zoneCode+'/'+nameBird)
            .pipe(map(res => res.json()));
    }

    getBird(codigo){
        return this._http.get(this.url+'birds/'+codigo)
            .pipe(map(res => res.json()));
    }

    editBird(bird:Bird){
        let json = JSON.stringify(bird);
        let params = json;
        let headers = new Headers({'Content-Type':'application/json;charset=UTF-8'});
        return this._http.put(this.url+'birds/',params,{headers:headers})
            .pipe(map(res => res.json()));
    }

    deleteBird(codigo){
         let headers = new Headers({'Content-Type':'application/json;charset=UTF-8'});
        return this._http.delete(this.url+'birds/'+codigo,{headers:headers})
            .pipe(map(res => res.json()));
    }

    addBird(bird: Bird){
        let json = JSON.stringify(bird);
        let params = json;
        let headers = new Headers({'Content-Type':'application/json;charset=UTF-8'});

        return this._http.post(this.url+'birds',params,{headers:headers})
            .pipe(map(res => res.json()));
    }


}
