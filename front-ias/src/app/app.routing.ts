import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

//Components
import { HomeComponent } from './components/home.component';
import { BirdListComponent } from './components/bird/bird-list.component';
import { BirdAddComponent } from './components/bird/bird-add.component';
//import { ProductoDetailComponent } from './components/bird/bird-detail.component';
import { BirdEditComponent } from './components/bird/bird-edit.component';
import { ErrorComponent } from './components/error.component';


const appRoutes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'home', component: HomeComponent},
    {path: 'birds', component: BirdListComponent},
    {path: 'addBird', component: BirdAddComponent},
    //{path: 'bird/:id', component: ProductoDetailComponent},
    {path: 'edit-bird/:id', component: BirdEditComponent},
    {path: '**', component: ErrorComponent}
];

export const appRoutingProviders: any[] = [];
export const routing:ModuleWithProviders = RouterModule.forRoot(appRoutes);
