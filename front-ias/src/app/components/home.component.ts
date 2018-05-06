import { Component } from '@angular/core'

@Component({
    selector: 'home',
    templateUrl: '../views/home.html'
})
export class HomeComponent{
    public titulo:string;
    constructor(){
        this.titulo = "Webapp de aves - FrontEnd - Reto IAS"
    }
    ngOnInit(){
        console.log('Se cargado el componente home home.component');
    }
}