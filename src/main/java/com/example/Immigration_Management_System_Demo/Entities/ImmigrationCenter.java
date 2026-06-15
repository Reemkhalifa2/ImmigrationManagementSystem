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
public class ImmigrationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String locationCountry;
    private String type;
    private Integer dailyCapacity;

    @OneToMany
    List<ImmigrationOfficer> immigrationOfficer;

}
