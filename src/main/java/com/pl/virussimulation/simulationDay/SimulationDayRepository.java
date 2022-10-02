package com.pl.virussimulation.simulationDay;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SimulationDayRepository extends CrudRepository<SimulationDay, Integer> {

    List<SimulationDay> findAllBySimulationId(Long simId);
}
