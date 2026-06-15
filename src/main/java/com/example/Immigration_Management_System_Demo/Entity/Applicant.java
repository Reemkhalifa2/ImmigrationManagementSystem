package com.example.Immigration_Management_System_Demo.Entity;

import jakarta.persistence.*;

@Entity
public class Applicant extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passportNumber;
    private String nationality;
    private Boolean criminalRecord;
    @OneToMany
    VisaApplication visaApplication;

    @OneToMany
    Interview interview;

}
