package com.pl.virussimulation.simulation;

import com.pl.virussimulation.simulationDay.SimulationDayService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SimulationService {

    private final  SimulationRepository simulationRepository;
    private final SimulationDayService simulationDayService;

    public List<Simulation> findAllSimulations(){
        List<Simulation> simulations = new LinkedList<>();
        simulationRepository.findAll().forEach(simulations::add);
        return simulations;
    }

    public void createSimulation(Simulation simulation){

        simulationRepository.save(simulation);
        simulationDayService.generateSimulationDays(simulation);
    }

    public void deleteSimulationById(Integer id){
        simulationRepository.deleteById(id);
    }

    public Simulation findSimulationByName(String name){
        return simulationRepository.findSimulationByN(name);
    }

}
