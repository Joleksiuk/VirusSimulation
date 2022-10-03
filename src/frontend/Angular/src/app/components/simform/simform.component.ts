import { Component,  Input,  OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestApiService } from 'src/app/shared/rest-api.service';
import { Simulation } from 'src/app/shared/simulation';

@Component({
  selector: 'app-simform',
  templateUrl: './simform.component.html',
  styleUrls: ['./simform.component.css']
})
export class SimformComponent implements OnInit {

 
  @Input() simDetails = { 
    SimName: 'test', 
    populationQuantity:0, 
    initialSick:0,
    infectionRate:0,
    deathRate:0,
    recoverRate:0,
    deathDays:0,
    recoverDays:0,
    simTime:0};

  constructor(public restApi: RestApiService, public router: Router) {}
  
  ngOnInit() {}
  addSimulation(simData: Simulation) {
    this.restApi.createSimulation(simData).subscribe((data: {}) => {
      this.router.navigate(['/simulation-list']);
    });
  }

}
