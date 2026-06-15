package com.example.Immigration_Management_System_Demo.Entities;

import jakarta.persistence.*;
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
    private String badgeNumber;
    private String officerRank;
    private Integer clearanceLevel;
    private Boolean active;

    @ManyToOne
    private ImmigrationCenter center;
    @OneToMany
    private List<Interview> interviews;

}
