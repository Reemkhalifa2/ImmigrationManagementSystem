package com.example.Immigration_Management_System_Demo.Entity;

import jakarta.persistence.*;

@Entity
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String interviewDate;
    private String status;
    private String purpose;
    @ManyToOne
    Applicant applicant;
    @ManyToOne
    ImmigrationOfficer immigrationOfficer;

}
