export interface Simulation {
    id: number;
    simulationName:String; //simulation name
    popularQunatity:number; //population quantity
    iinitialQuantity:number; //initial quantity of sick
    infectionRate:number; //infection rate
    deathRate:number; //death rate
    daysToRecover:number; //avg days to recover
    daysToDie:number; //avg days to die
    timeOfSimulation:number ; // time of simulation

}
