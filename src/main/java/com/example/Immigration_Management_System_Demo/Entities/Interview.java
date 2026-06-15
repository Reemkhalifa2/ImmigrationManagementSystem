package com.example.Immigration_Management_System_Demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
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
    private ImmigrationOfficer immigrationOfficer;

}
