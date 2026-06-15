package com.example.Immigration_Management_System_Demo.Entity;

import jakarta.persistence.Entity;

@Entity
public class BorderControlofficer extends ImmigrationOfficer{
    private String assignedCheckpoint;
    private Boolean k9UnitAssigned;
}
