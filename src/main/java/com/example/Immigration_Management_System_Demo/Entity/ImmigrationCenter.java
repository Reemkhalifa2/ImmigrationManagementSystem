package com.example.Immigration_Management_System_Demo.Entity;

import jakarta.persistence.*;

@Entity
public class ImmigrationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String locationCountry;
    private String type;
    private Integer dailyCapacity;

    @OneToMany
    ImmigrationOfficer immigrationOfficer;
}
