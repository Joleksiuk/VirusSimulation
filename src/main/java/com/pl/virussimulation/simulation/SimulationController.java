package com.pl.virussimulation.simulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("simulation")
public class SimulationController {

    private final SimulationService simulationService;

    @Autowired
    public SimulationController(SimulationService simulationService){this.simulationService = simulationService;}

    @GetMapping
    public List<Simulation> getAllSimulations() {
        return simulationService.findAllSimulations();
    }

    @PostMapping
    public void createSimulation(@RequestBody Simulation simulation) {
        simulationService.createSimulation(simulation);
    }

    @DeleteMapping("{id}")
    public void deleteSimulation(@PathVariable Integer id) {
        simulationService.deleteSimulationById(id);
    }
}
