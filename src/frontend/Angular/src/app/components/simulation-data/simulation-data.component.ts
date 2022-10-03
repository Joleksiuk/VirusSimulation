import { Component, OnInit } from '@angular/core';
import { RestApiService } from 'src/app/shared/rest-api.service';

@Component({
  selector: 'app-simulation-list',
  templateUrl: './simulation-data.component.html',
  styleUrls: ['./simulation-data.component.css']
})
export class SimulationDataComponent implements OnInit {

  Simulations: any=[];
  constructor(public restApi: RestApiService) { }

  ngOnInit(): void {
    this.loadSimulationData();
  }
  loadSimulationData() {
    return this.restApi.getSimDaysBySimId(1).subscribe((data: {}) => {
      this.Simulations = data;
    });
  }

}


