import { Component } from '@angular/core';
import { GLOBAL } from './services/global';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  public title:string = 'Demo IAS';
  public header_color:string;
  constructor(){
    this.header_color = GLOBAL.header_color;
  }
}
