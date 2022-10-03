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
    n: 'test', 
    p:0, 
    i:0,
    r:0,
    m:0,
    ti:0,
    tm:0,
    ts:0};

  constructor(public restApi: RestApiService, public router: Router) {}
  
  ngOnInit() {}
  addSimulation(simData: any) {
    this.restApi.createSimulation(simData).subscribe((data: {}) => {
      this.router.navigate(['/data']);
    });
  }

}
