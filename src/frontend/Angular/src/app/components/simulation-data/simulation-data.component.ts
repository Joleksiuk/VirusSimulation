import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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

  simName:any="";
  simulation:any;

  constructor(public restApi: RestApiService, private route:ActivatedRoute) {
    this.simName = this.route.snapshot.paramMap.get("msg"); 
    console.log(this.simName)
   }

  ngOnInit(): void {
    console.log("gnOnInit")
    this.loadSimulationData();

  }

  loadSimulationData() {
    return this.restApi.getSimDaysBySimName(this.simName).subscribe((data: {}) => {
      this.simData = data;
      console.log(data)
      this.loadArrays();
   
    });
  }

  getChartInstance(chart: object) {
		this.chart = chart;
	}

  loadArrays(){
    console.log(this.simData)
    this.simData.forEach((element: SimulationDay)=> {
      this.pi.push({ x: element.n , y: element.pi });
      this.pv.push({ x: element.n , y: element.pv });
      this.pm.push({ x: element.n , y: element.pm });
      this.pr.push({ x: element.n , y: element.pr });  
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


