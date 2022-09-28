import { Component, OnInit } from '@angular/core';
import { RestApiService } from 'src/app/shared/rest-api.service';

@Component({
  selector: 'app-simulation-list',
  templateUrl: './simulation-list.component.html',
  styleUrls: ['./simulation-list.component.css']
})
export class SimulationListComponent implements OnInit {

  Simulations: any=[];
  constructor(public restApi: RestApiService) { }

  ngOnInit(): void {
    this.loadSimulations();
  }
  loadSimulations() {
    return this.restApi.getSimulations().subscribe((data: {}) => {
      this.Simulations = data;
    });
  }

}


