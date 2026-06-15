package com.example.Immigration_Management_System_Demo.Entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class Person {

    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
}
