package com.pl.virussimulation.simulationDay;

import com.pl.virussimulation.simulation.Simulation;
import com.pl.virussimulation.simulation.SimulationManager;
import com.pl.virussimulation.simulation.SimulationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SimulationDayService {
    private final SimulationDayRepository simulationDayRepository;

    public List<SimulationDay> findAllSimulationDays(){
        List<SimulationDay> simulationDays = new LinkedList<>();
        simulationDayRepository.findAll().forEach(simulationDays::add);
        return simulationDays;
    }

    public List<SimulationDay> findAllDaysBySimulationID(Long simId){
        return simulationDayRepository.findAllBySimulationId(simId);
    }

    public void createSimulationDay(SimulationDay SimulationDay){
        simulationDayRepository.save(SimulationDay);
    }

    public void generateSimulationDays(Simulation simulation){
        SimulationManager simManager =new SimulationManager(simulation);
        simManager.startSimulation();

        for(SimulationDay day: simManager.getSimDays()){
            createSimulationDay(day);
        }

    }

}
