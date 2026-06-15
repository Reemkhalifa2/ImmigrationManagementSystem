package com.example.Immigration_Management_System_Demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Applicant extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passportNumber;
    private String nationality;
    private Boolean criminalRecord;
    @OneToMany
    List<VisaApplication> visaApplications;
    @OneToMany
    List<Interview> interview;

}
