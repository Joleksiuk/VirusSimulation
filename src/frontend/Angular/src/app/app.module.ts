import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SimformComponent } from './components/simform/simform.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SimulationListComponent } from './components/simulation-list/simulation-list.component';


@NgModule({
  declarations: [
    AppComponent,
    SimformComponent,
    SimulationListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
