package com.pl.virussimulation.simulation;

import com.pl.virussimulation.simulationDay.SimulationDay;
import com.pl.virussimulation.simulationDay.SimulationDayService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SimulationManager {

    private Simulation simulation;
    private List<SimulationDay> simDays =new ArrayList<SimulationDay>();

    @Autowired
    private final SimulationDayService simulationDayService;

    public SimulationManager(Simulation simulation, SimulationDayService simulationDayService) {
        this.simulation = simulation;
        this.simulationDayService = simulationDayService;
    }

    public void startSimulation(){
        initializeFirstDay();

        for(int i=1; i<= simulation.getTs();i++){
            simulateDay(i);
        }
    }

    public void initializeFirstDay(){
        SimulationDay simulationDay=new SimulationDay();
        simulationDay.setSimulationId(simulation.getId());
        simulationDay.setPi(simulation.getI());
        simulationDay.setPv(simulation.getP()- simulation.getI());
        simulationDay.setPm(0);
        simulationDay.setPr(0);
        simulationDay.setN(0);
        simDays.add(simulationDay);
        simulationDayService.createSimulationDay(simulationDay);
    }

    public void simulateDay(int dayNumber){

        SimulationDay newDay=new SimulationDay();
        newDay.setSimulationId(simulation.getId());
        newDay.setN(dayNumber);

        SimulationDay dayBefore;
        if(simDays.size()>0){
            dayBefore=simDays.get(dayNumber-1);
            newDay.setPi(dayBefore.getPi());
            newDay.setPm(dayBefore.getPm());
            newDay.setPv(dayBefore.getPv());
            newDay.setPr(dayBefore.getPr());
        }

        if(dayNumber>=simulation.getTm()){
            int newDeaths = simDays.get(dayNumber-simulation.getTm()).getPm()+simulation.getM() ;
            newDay.setPm(Math.max(Math.min(newDeaths, simulation.getP()),0));
            newDay.setPi(Math.max(Math.min(newDay.getPi()-simulation.getM(), simulation.getP()),0));
        }

        if(dayNumber>=simulation.getTi()){
            int newRecoveries = simDays.get(dayNumber- simulation.getTi()).getPi()+ simulation.getR();
            newDay.setPi(Math.max(Math.min(newDay.getPi()-newRecoveries, simulation.getP()),0));
            newDay.setPr(Math.max(Math.min(newDay.getPr()+newRecoveries, simulation.getP()),0));
        }

        int newCases = newDay.getPi()* simulation.getR();
        newDay.setPi(Math.max(Math.min(newDay.getPi()+newCases, simulation.getP()),0));

        simDays.add(newDay);
        simulationDayService.createSimulationDay(newDay);

    }
}
