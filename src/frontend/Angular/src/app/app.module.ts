import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SimformComponent } from './components/simform/simform.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SimulationDataComponent as SimulationDataComponent } from './components/simulation-data/simulation-data.component';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '/simData', component: SimulationDataComponent, }
];

@NgModule({
  declarations: [
    AppComponent,
    SimformComponent,
    SimulationDataComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    RouterModule.forRoot(routes)

    
  ],
  providers: [],
  bootstrap: [AppComponent]

  
})
export class AppModule { }
