package com.example.Immigration_Management_System_Demo.Controllers;

import com.example.Immigration_Management_System_Demo.Entities.*;
import com.example.Immigration_Management_System_Demo.Repository.ApplicantRepository;
import com.example.Immigration_Management_System_Demo.Repository.CenterRepository;
import com.example.Immigration_Management_System_Demo.Repository.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DatabaseSeedController {

    @Autowired
    private CenterRepository centerRepository;

    @Autowired
    private OfficerRepository officerRepository;

    @Autowired
    private ApplicantRepository applicantRepository;


    @PostMapping("/seed")
    public String seedDatabase() {

        ImmigrationCenter center1 = new ImmigrationCenter();
        center1.setName("Muscat Immigration Center");
        center1.setLocationCountry("Oman");
        center1.setType("Main");
        center1.setDailyCapacity(500);


        ImmigrationCenter center2 = new ImmigrationCenter();
        center2.setName("Salalah Border Center");
        center2.setLocationCountry("Oman");
        center2.setType("Border");
        center2.setDailyCapacity(300);


        centerRepository.save(center1);
        centerRepository.save(center2);



        // ================= Officers =================

        ImmigrationOfficer officer1 = new ImmigrationOfficer();
        officer1.setFirstName("Ahmed");
        officer1.setLastName("Al Ali");
        officer1.setBadgeNumber("OF001");
        officer1.setOfficerRank("Senior Officer");
        officer1.setClearanceLevel(5);
        officer1.setActive(true);
        officer1.setCenter(center1);


        ImmigrationOfficer officer2 = new ImmigrationOfficer();
        officer2.setFirstName("Sara");
        officer2.setLastName("Mohammed");
        officer2.setBadgeNumber("OF002");
        officer2.setOfficerRank("Junior Officer");
        officer2.setClearanceLevel(2);
        officer2.setActive(true);
        officer2.setCenter(center1);


        BorderControlofficer officer3 = new BorderControlofficer();
        officer3.setFirstName("Khalid");
        officer3.setLastName("Hassan");
        officer3.setBadgeNumber("BC001");
        officer3.setOfficerRank("Border Controller");
        officer3.setClearanceLevel(4);
        officer3.setActive(true);
        officer3.setAssignedCheckpoint("Muscat Airport");
        officer3.setK9UnitAssigned(true);
        officer3.setCenter(center2);


        officerRepository.save(officer1);
        officerRepository.save(officer2);
        officerRepository.save(officer3);



        // ================= Applicants =================

        Applicant applicant1 = new Applicant();
        applicant1.setFirstName("Ali");
        applicant1.setLastName("Hamed");
        applicant1.setPassportNumber("OM1001");
        applicant1.setNationality("Omani");
        applicant1.setCriminalRecord(false);


        Applicant applicant2 = new Applicant();
        applicant2.setFirstName("Noor");
        applicant2.setLastName("Salim");
        applicant2.setPassportNumber("AE2002");
        applicant2.setNationality("Emirati");
        applicant2.setCriminalRecord(true);


        Applicant applicant3 = new Applicant();
        applicant3.setFirstName("John");
        applicant3.setLastName("Smith");
        applicant3.setPassportNumber("UK3003");
        applicant3.setNationality("British");
        applicant3.setCriminalRecord(false);


        AsylumSeeker applicant4 = new AsylumSeeker();
        applicant4.setFirstName("Omar");
        applicant4.setLastName("Nasser");
        applicant4.setPassportNumber("SY4004");
        applicant4.setNationality("Syrian");
        applicant4.setCriminalRecord(false);
        applicant4.setCountryOfOrigin("Syria");
        applicant4.setSponsorOrganization("UNHCR");


        applicantRepository.save(applicant1);
        applicantRepository.save(applicant2);
        applicantRepository.save(applicant3);
        applicantRepository.save(applicant4);



        return "Database seeded successfully!";
    }
}