import { Component, OnInit } from '@angular/core';
import { RestApiService } from 'src/app/shared/rest-api.service';
import { SimulationDay } from 'src/app/shared/simulationDay';

@Component({
  selector: 'app-simulation-list',
  templateUrl: './simulation-data.component.html',
  styleUrls: ['./simulation-data.component.css']
})
export class SimulationDataComponent implements OnInit {

  simData: any=[];
  pi:any =[];
  pv:any = [];
  pm: any  =[];
  pr: any=[];


  constructor(public restApi: RestApiService) { }

  ngOnInit(): void {
    this.loadSimulationData();
  }

  loadSimulationData() {
    return this.restApi.getSimDaysBySimId(141).subscribe((data: {}) => {
      this.simData = data;
      this.loadArrays();
   
    });
  }

  getChartInstance(chart: object) {
		this.chart = chart;
	}

  loadArrays(){
    console.log(this.simData)
    this.simData.forEach((element: SimulationDay)=> {
      this.pi.push({ x: element.pi , y: element.n });
      this.pv.push({ x: element.pv , y: element.n });
      this.pm.push({ x: element.pm , y: element.n });
      this.pr.push({ x: element.pr , y: element.n });  
    });
    this.chart.render();
  }

  chart: any;
	
	chartOptions = {
	  animationEnabled: true,
	  theme: "light2",
	  title:{text: "Simulation data"},
	  toolTip: {shared: true},
	  legend: {
		cursor: "pointer",
		itemclick: function (e: any) {
			if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
				e.dataSeries.visible = false;
			} else {
				e.dataSeries.visible = true;
			} 
			e.chart.render();
		}
	  },
	  data: [
    {
      type: "line",
		  showInLegend: true,
		  name: "pi",
		  dataPoints: this.pi
	  },
    {
		  type: "line",
		  showInLegend: true,
		  name: "pv",
		  dataPoints: this.pv
	  },
    {
      type: "line",
      showInLegend: true,
      name: "pm",   
      dataPoints:this.pm
    },
    {
      type: "line",
      showInLegend: true,
      name: "pr",   
      dataPoints:this.pr
    }
  ]
    
	}	

}


