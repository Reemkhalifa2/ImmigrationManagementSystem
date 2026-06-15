package com.example.Immigration_Management_System_Demo.Services;

import com.example.Immigration_Management_System_Demo.Entities.Applicant;
import com.example.Immigration_Management_System_Demo.Entities.Interview;
import com.example.Immigration_Management_System_Demo.Repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicantService {
    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    ApplicantRepository applicantRepository;


    public Applicant saveApplicant(Applicant applicant){
        if(applicant.getPassportNumber().isBlank()){
            throw new RuntimeException("Passport Number cannot be empty.");
        }
        if(applicant.getFirstName().isBlank() || applicant.getLastName().isBlank()){
            throw new RuntimeException("Name Cannot be empty.");
        }
        return applicantRepository.save(applicant);
    }

    public Applicant saveApplicant(String firstName, String lastName, String passportNumber, String nationality){
        Applicant applicant = new Applicant();
        if(applicant.getPassportNumber().isBlank()){
            throw new RuntimeException("Passport Number cannot be empty.");
        }
        if(applicant.getNationality().isBlank()){
            throw new RuntimeException("Nationality cannot be empty.");
        }
        if(applicant.getFirstName().isBlank() || applicant.getLastName().isBlank()){
            throw new RuntimeException("Name Cannot be empty.");
        }
        applicant.setFirstName(firstName);
        applicant.setLastName(lastName);
        applicant.setPassportNumber(passportNumber);
        applicant.setNationality(nationality);
        return applicantRepository.save(applicant);
    }


    public Applicant flagCriminalRecord(Long applicantId){
        if(applicantId == null){
            throw new RuntimeException("Id cannot be null");
        }
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
        applicant.setCriminalRecord(Boolean.TRUE);
        for(Interview interview : applicant.getInterview()){
            interview.setStatus("CANCELLED");
        }
        return applicantRepository.save(applicant);
    }

}
