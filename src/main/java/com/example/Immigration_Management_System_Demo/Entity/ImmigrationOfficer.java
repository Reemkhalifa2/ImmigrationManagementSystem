package com.example.Immigration_Management_System_Demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ImmigrationOfficer extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String badgeNumber;
    private String rank;
    private Integer clearanceLevel;
    private Boolean active;

    @ManyToOne
    ImmigrationCenter immigrationCenter;
    @OneToMany
    List<Interview> interview;
}
