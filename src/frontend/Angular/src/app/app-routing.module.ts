import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SimformComponent } from './components/simform/simform.component';
import { SimulationDataComponent } from './components/simulation-data/simulation-data.component';

const routes: Routes = [
  { path:'simulation', component:SimformComponent },
  { path:'data', component:SimulationDataComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [SimformComponent, SimulationDataComponent]
