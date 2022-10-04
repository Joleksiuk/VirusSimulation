package com.pl.virussimulation.simulation;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SimulationRepository extends CrudRepository<Simulation, Integer> {
    Simulation findSimulationByN(String Name);
}
