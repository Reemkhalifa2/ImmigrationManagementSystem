package com.example.Immigration_Management_System_Demo.Entity;

import jakarta.persistence.*;

@Entity
public class VisaApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    Applicant applicant;

    @ManyToOne
    ImmigrationOfficer immigrationOfficer;

}
