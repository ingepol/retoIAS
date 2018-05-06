import { Component } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { BirdService } from '../../services/bird.service';
import { Bird } from '../../models/bird'


@Component({
    selector: 'bird-list',
    templateUrl: '../../views/bird/bird-list.html',
    providers: [BirdService]
})
export class BirdListComponent{
    public titulo:string;
    public birds: Bird[];

    constructor(
        private _route: ActivatedRoute,
        private _router:Router,
        private _birdService: BirdService
    ){
        this.titulo = 'Listado de aves';
    }
    ngOnInit(){
        console.log('bird-list.component.ts cargado.');
        this.getBirds();
    }

    deleteBird(codigo){
        this._birdService.deleteBird(codigo).subscribe(
            response => {
                if(response.code == 200){
                    this.getBirds();
                }else{
                    console.log(response);
                }
            },
            error => {
                console.log(<any>error);
            }
        );
    }

    getBirds(){
        this._birdService.getBirds().subscribe(
            result => {
                
                if(result.code!=200){
                    console.log(result);
                }else{
                    this.birds = result.data;
                }
            },
            error => {
                console.log(<any>error);
            }
        );
    }
}
