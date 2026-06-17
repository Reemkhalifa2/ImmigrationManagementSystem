package com.example.Immigration_Management_System_Demo.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    @NotNull(message = "Interview date is required")
    private String interviewDate;
    @NotBlank(message = "Status is required")
    @Pattern(
            regexp = "^(SCHEDULED|COMPLETED|CANCELLED)$",
            message = "Status must SCHEDULED|COMPLETED|CANCELLED"
    )
    private String status;
    private String purpose;
    @ManyToOne
    Applicant applicant;
    @ManyToOne
    private ImmigrationOfficer immigrationOfficer;

}
