package com.example.Immigration_Management_System_Demo.Services;

import DTO.ApplicantDTO;
import com.example.Immigration_Management_System_Demo.Entities.Applicant;
import com.example.Immigration_Management_System_Demo.Entities.AsylumSeeker;
import com.example.Immigration_Management_System_Demo.Entities.Interview;
import com.example.Immigration_Management_System_Demo.Exceptions.ApplicantException;
import com.example.Immigration_Management_System_Demo.Repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {
    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    ApplicantRepository applicantRepository;


    public Applicant saveApplicant(Applicant applicant) {
        if (applicant.getPassportNumber() == null || applicant.getPassportNumber().isBlank()) {
            throw ApplicantException.badRequest("Passport number cannot be empty.");
        }
        if (applicant.getFirstName() == null || applicant.getFirstName().isBlank()
                || applicant.getLastName() == null || applicant.getLastName().isBlank()) {
            throw ApplicantException.badRequest("Name cannot be empty.");
        }
        return applicantRepository.save(applicant);
    }

    public Applicant saveApplicant(String firstName, String lastName,
                                   String passportNumber, String nationality) {

        if (passportNumber == null || passportNumber.isBlank()) {
            throw ApplicantException.badRequest("Passport number cannot be empty.");
        }
        if (nationality == null || nationality.isBlank()) {
            throw ApplicantException.badRequest("Nationality cannot be empty.");
        }
        if (firstName == null || firstName.isBlank() || lastName == null || lastName.isBlank()) {
            throw ApplicantException.badRequest("Name cannot be empty.");
        }

        Applicant applicant = new Applicant();
        applicant.setFirstName(firstName);
        applicant.setLastName(lastName);
        applicant.setPassportNumber(passportNumber);
        applicant.setNationality(nationality);

        return applicantRepository.save(applicant);
    }


    public AsylumSeeker saveApplicant(AsylumSeeker asylumSeeker) {
        if (asylumSeeker == null) {
            throw ApplicantException.badRequest("Asylum seeker data cannot be null.");
        }
        return applicantRepository.save(asylumSeeker);
    }

    public Applicant flagCriminalRecord(Long applicantId) {
        if (applicantId == null) {
            throw ApplicantException.badRequest("Applicant ID cannot be null.");
        }

        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> ApplicantException.notFound(Math.toIntExact(applicantId)));

        applicant.setCriminalRecord(Boolean.TRUE);
        for (Interview interview : applicant.getInterview()) {
            interview.setStatus("CANCELLED");
        }

        return applicantRepository.save(applicant);
    }
    public List<ApplicantDTO> getAll(){
        return ApplicantDTO.convertToDTO(applicantRepository.getALl());
    }

    public List<ApplicantDTO> search(String nationality) {
        return  ApplicantDTO.convertToDTO(applicantRepository.findByNationality(nationality));
    }



}
