package com.pl.virussimulation.simulationDay;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "simulation_day",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id")})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SimulationDay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;
    Integer simulationId;
    String simDate;
    Integer n;
    Integer pi; //number of sick
    Integer pv; //number of infected

    public SimulationDay(Integer simulationId, String simDate, Integer n, Integer pi, Integer pv, Integer pm, Integer pr) {
        this.simulationId = simulationId;
        this.simDate = simDate;
        this.n = n;
        this.pi = pi;
        this.pv = pv;
        this.pm = pm;
        this.pr = pr;
    }

    Integer pm; //number of deaths
    Integer pr; //number of recovered
}
