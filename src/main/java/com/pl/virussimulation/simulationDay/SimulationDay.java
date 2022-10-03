package com.pl.virussimulation.simulationDay;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "simulation_day")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SimulationDay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;
    Long simulationId;
    Integer n;
    Integer pi; //number of sick
    Integer pv; //number of infected
    Integer pm; //number of deaths
    Integer pr; //number of recovered

    public SimulationDay(Long simulationId, Integer n, Integer pi, Integer pv, Integer pm, Integer pr) {
        this.simulationId = simulationId;
        this.n = n;
        this.pi = pi;
        this.pv = pv;
        this.pm = pm;
        this.pr = pr;
    }

}
