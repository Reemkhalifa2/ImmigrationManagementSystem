package com.example.Immigration_Management_System_Demo.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class VisaApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String visaType;
    @NotBlank(message = "Status is required")
    @Pattern(
            regexp = "^(PENDING|APPROVED|REJECTED)$",
            message = "Status must be PENDING, APPROVED, or REJECTED"
    )
    private String status;    private String officerNotes;


    @ManyToOne
    Applicant applicant;
    @ManyToOne
    ImmigrationOfficer immigrationOfficer;

}
