package com.example.Immigration_Management_System_Demo.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ImmigrationOfficer extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Badge number is required")
    private String badgeNumber;

    @NotBlank(message = "Officer rank is required")
    private String officerRank;

    @NotNull(message = "Clearance level is required")
    @Min(value = 1, message = "Clearance level must be at least 1")
    @Max(value = 5, message = "Clearance level must not exceed 5")
    private Integer clearanceLevel;

    @NotNull(message = "Active status is required")
    private Boolean active;

    @ManyToOne
    private ImmigrationCenter center;
    @OneToMany
    private List<Interview> interviews;

}
