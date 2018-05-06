import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

//Routing
import { routing, appRoutingProviders } from './app.routing';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home.component';
import { BirdListComponent } from './components/bird/bird-list.component';
import { BirdAddComponent } from './components/bird/bird-add.component';
//import { ProductoDetailComponent } from './components/bird/bird-detail.component';
import { BirdEditComponent } from './components/bird/bird-edit.component';
import { ErrorComponent } from './components/error.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BirdListComponent,
    BirdAddComponent,
    //ProductoDetailComponent,
    BirdEditComponent,
    ErrorComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [appRoutingProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
