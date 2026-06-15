package com.example.Immigration_Management_System_Demo.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Passport cannot be blank.")
    private String passportNumber;
    @NotBlank(message = "Nationality cannot be blank.")
    private String nationality;
    private Boolean criminalRecord;
    @OneToMany
    List<VisaApplication> visaApplications;
    @OneToMany
    List<Interview> interview;

}
