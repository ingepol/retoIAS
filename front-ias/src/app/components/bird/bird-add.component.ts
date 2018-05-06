import { Component } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { BirdService } from '../../services/bird.service';
import { CountryService } from '../../services/country.service';
import { Bird } from '../../models/bird';
import { Country } from '../../models/country';

@Component({
    selector: 'bird-add',
    templateUrl: '../../views/bird/bird-add.html',
    providers: [BirdService, CountryService]
})
export class BirdAddComponent{
    public titulo:string;
    public bird:Bird;
    public countries: Country[];
    public countrySelected:any;
    
    constructor(
        private _birdService:BirdService,
        private _countryService:CountryService,
        private _route: ActivatedRoute,
        private _router: Router
    ){
        
        this.bird = new Bird(0,'','',null);
    }
    ngOnInit(){
        console.log("bird-add.component.ts cargando...");
        this.getCountries();
    }
    onSubmit(){
        console.log(this.bird);
        this.saveBird();
    }

    getCountries(){
        this._countryService.getCountries().subscribe(
            result => {
                console.log(result);
                if(result.code!=200){
                    console.log(result);
                }else{
                    this.countries = result.data;
                }
            },
            error => {
                console.log(<any>error);
            }
        );
    }

    inSelectedCountries(c1: Country, c2: Country): boolean {
        return false;
    }

    saveBird(){
        this._birdService.addBird(this.bird).subscribe(
            response => {
                if(response.code == 200){
                    this._router.navigate(['/birds']);
                }else{
                    console.log(response);
                }
            },
            error => {
                console.log(<any>error);
            }
        );
    }

}