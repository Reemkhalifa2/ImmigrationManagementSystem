package com.example.Immigration_Management_System_Demo.Entity;

import jakarta.persistence.Entity;

@Entity
public class AsylumSeeker extends Applicant{

    private String countryOfOrigin;
    private String sponsorOrganization;
}
