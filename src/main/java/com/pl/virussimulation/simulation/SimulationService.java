package com.pl.virussimulation.simulation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SimulationService {

    private final  SimulationRepository simulationRepository;


    public List<Simulation> findAllSimulations(){
        List<Simulation> simulations = new LinkedList<>();
        simulationRepository.findAll().forEach(simulations::add);
        return simulations;
    }

    public void createSimulation(Simulation simulation){
        simulationRepository.save(simulation);
    }

    public void deleteSimulationById(Integer id){
        simulationRepository.deleteById(id);
    }
}
