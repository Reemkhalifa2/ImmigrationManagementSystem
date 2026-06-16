package com.example.Immigration_Management_System_Demo.Services;

import com.example.Immigration_Management_System_Demo.Entities.Applicant;
import com.example.Immigration_Management_System_Demo.Entities.AsylumSeeker;
import com.example.Immigration_Management_System_Demo.Entities.Interview;
import com.example.Immigration_Management_System_Demo.Repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Applicant saveApplicant(String firstName, String lastName,
                                   String passportNumber, String nationality) {

        if (passportNumber == null || passportNumber.isBlank()) {
            throw new RuntimeException("Passport Number cannot be empty.");
        }

        if (nationality == null || nationality.isBlank()) {
            throw new RuntimeException("Nationality cannot be empty.");
        }

        if (firstName == null || firstName.isBlank() ||
                lastName == null || lastName.isBlank()) {
            throw new RuntimeException("Name cannot be empty.");
        }

        Applicant applicant = new Applicant();

        applicant.setFirstName(firstName);
        applicant.setLastName(lastName);
        applicant.setPassportNumber(passportNumber);
        applicant.setNationality(nationality);

        return applicantRepository.save(applicant);
    }


    public AsylumSeeker saveApplicant(AsylumSeeker asylumSeeker){
        if(asylumSeeker != null)  return applicantRepository.save(asylumSeeker) ;
        throw new RuntimeException("Seeker cannot be empty.");
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
    public List<Applicant> getAll(){
        return applicantRepository.findAll().stream().toList();
    }

    public List<Applicant> search(String nationality) {
        return applicantRepository.findByNationality(nationality);
    }



}
