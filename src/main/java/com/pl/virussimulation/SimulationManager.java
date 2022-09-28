package com.pl.virussimulation;

import com.pl.virussimulation.simulation.Simulation;
import com.pl.virussimulation.simulationDay.SimulationDay;

import java.util.ArrayList;
import java.util.List;

public class SimulationManager {

    Simulation simulation;
    List<SimulationDay> simDays =new ArrayList<SimulationDay>();

    public SimulationManager(Simulation simulation) {
        this.simulation = simulation;
    }

    public void startSimulation(){
        initializeFirstDay();
    }

    public void initializeFirstDay(){
        SimulationDay simulationDay=new SimulationDay();
        simulationDay.setSimulationId(simulation.getId());
        simulationDay.setPi(simulation.getI());
        simulationDay.setPv(simulation.getP()- simulation.getI());
        simulationDay.setPm(0);
        simulationDay.setPr(0);
    }

    public void simulateDay(int dayNumber){

        SimulationDay newDay=new SimulationDay();
        newDay.setSimulationId(simulation.getId());

        SimulationDay dayBefore;
        if(dayNumber>0){
            dayBefore=simDays.get(dayNumber-1);
            newDay.setPi(dayBefore.getPi());
            newDay.setPm(dayBefore.getPm());
            newDay.setPv(dayBefore.getPv());
            newDay.setPr(dayBefore.getPr());
        }

        if(dayNumber>=simulation.getTm()){
            int newDeaths = simDays.get(dayNumber-simulation.getTm()).getPm()+simulation.getM() ;
            newDay.setPm(newDeaths);
            newDay.setPi(newDay.getPi()-simulation.getM());
        }

        if(dayNumber>=simulation.getTi()){
            int newRecoveries = simDays.get(dayNumber- simulation.getTi()).getPi()+ simulation.getR();
            newDay.setPi(newDay.getPi()-newRecoveries);
            newDay.setPr(newDay.getPr()+newRecoveries);
        }

        int newCases = newDay.getPi()* simulation.getR();
        newDay.setPi(newDay.getPi()+newCases);

        simDays.add(newDay);

    }
}
