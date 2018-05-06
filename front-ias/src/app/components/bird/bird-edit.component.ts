import { Component } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { BirdService } from '../../services/bird.service';
import { CountryService } from '../../services/country.service';
import { Bird } from '../../models/bird';
import { Country } from '../../models/country';

@Component({
    selector: 'bird-edit',
    templateUrl: '../../views/bird/bird-add.html',
    providers: [BirdService, CountryService]
})
export class BirdEditComponent{

    public bird:Bird;
    public countries:Country[];
    public titulo:string;
    public is_edit

    constructor(
        private _birdService:BirdService,
        private _countryService:CountryService,
        private _route: ActivatedRoute,
        private _router: Router
    ){
         this.bird = new Bird(0,'','',null);
         this.is_edit = true;
    }
    ngOnInit(){
        console.log("bird-edit.component.ts cargando...");
        this.getBird();
        this.getCountries();
    }
    
    getBird(){
        this._route.params.forEach((params:Params)=>{
            let id = params['id'];
            this._birdService.getBird(id).subscribe(
                response => {
                    if(response.code ==200){
                        this.bird = response.data;
                    }else{
                        this._router.navigate(['/birds']);
                    }
                },
                error=> {
                    console.log(<any>error);
                }
            );
        });
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
        return c1 && c2 ? c1.code === c2.code : c1 === c2;
    }

    onSubmit(){
        console.log(this.bird);
        this.updateBird();
    }

    updateBird(){

            this._birdService.editBird(this.bird).subscribe(
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