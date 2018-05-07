import { Component } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { BirdService } from '../../services/bird.service';
import { ZoneService } from '../../services/zone.service';
import { Bird } from '../../models/bird';
import { Zone } from '../../models/zone';


@Component({
    selector: 'bird-list',
    templateUrl: '../../views/bird/bird-list.html',
    providers: [BirdService,ZoneService]
})
export class BirdListComponent{
    public titulo:string;
    public birds: Bird[];
    public zones: Zone[];
    public zoneFilter:number;
    public nameFilter:string;

    constructor(
        private _route: ActivatedRoute,
        private _router:Router,
         private _birdService:BirdService,
        private _zoneService:ZoneService,
    ){
        this.titulo = 'Listado de aves';
    }
    ngOnInit(){
        console.log('bird-list.component.ts cargado.');
        this.zoneFilter=1;
        this.searchBirds();
        this.getZones();
    }

    deleteBird(codigo){
        this._birdService.deleteBird(codigo).subscribe(
            response => {
                if(response.code == 200){
                    this.searchBirds();
                }else{
                    console.log(response);
                }
            },
            error => {
                console.log(<any>error);
            }
        );
    }

    searchBirds(){
        this._birdService.getBirds(this.zoneFilter, this.nameFilter).subscribe(
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

    getZones(){
        this._zoneService.getZones().subscribe(
            result => {
                console.log(result);
                if(result.code!=200){
                    console.log(result);
                }else{
                    this.zones = result.data;
                }
            },
            error => {
                console.log(<any>error);
            }
        );
    }
}
