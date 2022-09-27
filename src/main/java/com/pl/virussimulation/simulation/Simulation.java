package com.pl.virussimulation.simulation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "players",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "nickname")})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Simulation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String n; //simulation name
    Integer p; //population quantity
    Integer i; //initial quantity of sick
    Integer r; //infection rate
    Integer m; //death rate
    Integer ti; //avg days to recover
    Integer tm; //avg days to die
    Integer ts; // time of simulation

}
