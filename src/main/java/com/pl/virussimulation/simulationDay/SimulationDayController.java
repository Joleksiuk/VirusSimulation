package com.pl.virussimulation.simulationDay;

import com.pl.virussimulation.simulation.Simulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("simulationday")
public class SimulationDayController {

    private final SimulationDayService simulationDayService;

    @Autowired
    public SimulationDayController(SimulationDayService simulationDayService) {
        this.simulationDayService=simulationDayService;
    }

    @GetMapping
    public List<SimulationDay> getAllSimulationDays() {
        return simulationDayService.findAllSimulationDays();
    }

    @GetMapping("{name}")
    public List<SimulationDay> getAllSimulationDaysBySimulationName(@PathVariable String name){
        return simulationDayService.findAllDaysBySimulationName(name);}

    @PostMapping
    public void createSimulationDay(@RequestBody SimulationDay simulationDay) {
        simulationDayService.createSimulationDay(simulationDay);
    }
}
