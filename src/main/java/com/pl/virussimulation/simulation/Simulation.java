package com.pl.virussimulation.simulation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "simulation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Simulation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;
    String n; //simulation name
    Integer p; //population quantity
    Integer i; //initial quantity of sick
    Integer r; //infection rate
    Integer m; //death rate
    Integer ti; //avg days to recover
    Integer tm; //avg days to die
    Integer ts; // time of simulation

    public Simulation(String n, Integer p, Integer i, Integer r, Integer m, Integer ti, Integer tm, Integer ts) {
        this.n = n;
        this.p = p;
        this.i = i;
        this.r = r;
        this.m = m;
        this.ti = ti;
        this.tm = tm;
        this.ts = ts;
    }
}
