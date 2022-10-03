export interface Simulation {
    n:String; //simulation name
    p:number; //population quantity
    i:number; //initial quantity of sick
    r:number; //infection rate
    m:number; //death rate
    ti:number; //avg days to recover
    tm:number; //avg days to die
    ts:number ; // time of simulation

}
