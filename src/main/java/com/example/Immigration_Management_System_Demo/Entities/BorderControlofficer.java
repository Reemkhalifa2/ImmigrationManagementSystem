package com.example.Immigration_Management_System_Demo.Entities;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BorderControlofficer extends ImmigrationOfficer{
    private String assignedCheckpoint;
    @NotNull(message = "Required")
    private Boolean k9UnitAssigned;
}
