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
    private  final SimulationRepository simulationRepository;


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
        SimulationManager simManager =new SimulationManager(simulation, this);
        simManager.startSimulation();
    }

    public List<SimulationDay> findAllDaysBySimulationName(String name){
        List<SimulationDay> days = new LinkedList<>();
        Simulation simulation = simulationRepository.findSimulationByN(name);
        if(simulation!=null){
            days = findAllDaysBySimulationID(simulation.getId());
        }
        return days;
    }

}
