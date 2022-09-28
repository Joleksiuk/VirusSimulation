import { Component,  Input,  OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestApiService } from 'src/app/shared/rest-api.service';

@Component({
  selector: 'app-simform',
  templateUrl: './simform.component.html',
  styleUrls: ['./simform.component.css']
})
export class SimformComponent implements OnInit {

 
  @Input() simDetails = { 
    SimName: '', 
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
  addSimulation(simData: any) {
    this.restApi.createSimulation(this.simDetails).subscribe((data: {}) => {
      this.router.navigate(['/simulation-list']);
    });
  }

}
