package com.pl.virussimulation.simulationDay;

import com.pl.virussimulation.simulation.Simulation;
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

    public void createSimulationDay(SimulationDay SimulationDay){
        simulationDayRepository.save(SimulationDay);
    }

    public void deleteSimulationDayById(Integer id){
        simulationDayRepository.deleteById(id);
    }
}
