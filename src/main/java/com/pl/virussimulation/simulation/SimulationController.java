package com.pl.virussimulation.simulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("simulation")
public class SimulationController {

    private final SimulationService simulationService;
    @Autowired
    public SimulationController(SimulationService simulationService){this.simulationService = simulationService;}

    @GetMapping
    public List<Simulation> getAllSimulations() {
        return simulationService.findAllSimulations();
    }
    @GetMapping("{name}")
    public  Simulation getSimulationByName(@RequestBody String name){
        return simulationService.findSimulationByName(name);
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
