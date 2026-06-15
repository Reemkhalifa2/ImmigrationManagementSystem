package com.example.Immigration_Management_System_Demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BorderControlofficer extends ImmigrationOfficer{
    private String assignedCheckpoint;
    private Boolean k9UnitAssigned;
}
