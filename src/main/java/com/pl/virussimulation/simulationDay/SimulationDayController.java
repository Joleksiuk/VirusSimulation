package com.pl.virussimulation.simulationDay;

import com.pl.virussimulation.simulation.Simulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("simulation_day")
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

    @GetMapping("{id}")
    public List<SimulationDay> getAllSimulationDaysBySimulationId(@PathVariable Long id){
        return simulationDayService.findAllDaysBySimulationID(id);}
    @PostMapping
    public void createSimulationDay(@RequestBody SimulationDay simulationDay) {
        simulationDayService.createSimulationDay(simulationDay);
    }
}
