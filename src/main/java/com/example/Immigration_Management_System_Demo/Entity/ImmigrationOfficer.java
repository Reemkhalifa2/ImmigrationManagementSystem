package com.example.Immigration_Management_System_Demo.Entity;

import jakarta.persistence.*;

@Entity
public class ImmigrationOfficer extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String badgeNumber;
    private String rank;
    private Integer clearanceLevel;
    private Boolean active;

    @ManyToOne
    ImmigrationCenter immigrationCenter;
    @OneToMany
    Interview interview;
}
