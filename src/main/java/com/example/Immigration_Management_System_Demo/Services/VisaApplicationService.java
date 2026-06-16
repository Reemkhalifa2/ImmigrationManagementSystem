package com.example.Immigration_Management_System_Demo.Services;

import com.example.Immigration_Management_System_Demo.Entities.Applicant;
import com.example.Immigration_Management_System_Demo.Entities.ImmigrationOfficer;
import com.example.Immigration_Management_System_Demo.Entities.VisaApplication;
import com.example.Immigration_Management_System_Demo.Repository.ApplicantRepository;
import com.example.Immigration_Management_System_Demo.Repository.OfficerRepository;
import com.example.Immigration_Management_System_Demo.Repository.VisaApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisaApplicationService {

    @Autowired
    public VisaApplicationService(ApplicantRepository applicantRepository,
                                  VisaApplicationRepository visaApplicationRepository , OfficerRepository officerRepository) {

        this.applicantRepository = applicantRepository;
        this.visaApplicationRepository = visaApplicationRepository;
        this.officerRepository = officerRepository;
    }
    OfficerRepository officerRepository;

    VisaApplicationRepository visaApplicationRepository;
    ApplicantRepository applicantRepository;

    public VisaApplication save(VisaApplication visaApplication){
        return visaApplicationRepository.save(visaApplication);
    }

    public VisaApplication assignReviewOfficer(Long visaId , Long officerId){
        VisaApplication visaApplication = visaApplicationRepository.findById(visaId).orElseThrow(
                ()-> new RuntimeException("Visa Not found!")
        );
        ImmigrationOfficer immigrationOfficer = officerRepository.getById(officerId);

        visaApplication.setImmigrationOfficer(immigrationOfficer);
        return visaApplicationRepository.save(visaApplication);
    }

    public VisaApplication submitApplication(Long applicantId, String visaType) {
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));

        VisaApplication visa = new VisaApplication();
        visa.setApplicant(applicant);
        visa.setVisaType(visaType);
        visa.setStatus("PENDING");

        if (applicant.getCriminalRecord() != null &&
                applicant.getCriminalRecord()) {

            visa.setStatus("REJECTED");
            visa.setOfficerNotes("Auto-rejected due to criminal flag.");
        }

        return visaApplicationRepository.save(visa);
    }

    public VisaApplication processVisa(Long visaId, String newStatus, String notes) {
        VisaApplication visa = visaApplicationRepository.findById(visaId)
                .orElseThrow(() -> new RuntimeException("Visa application not found"));

        if (!newStatus.equalsIgnoreCase("APPROVED") &&
                !newStatus.equalsIgnoreCase("REJECTED")) {
            throw new RuntimeException(
                    "Status must be APPROVED or REJECTED");
        }

        visa.setStatus(newStatus);
        visa.setOfficerNotes(notes);

        return visaApplicationRepository.save(visa);
    }

    public List<VisaApplication> getVisasByApplicant(Long applicantId) {

        return visaApplicationRepository.getVisasByApplicant(applicantId);
    }

    public List<VisaApplication> getVisasByStatus(String status) {
        return visaApplicationRepository.findByStatusIgnoreCase(status);
    }





}
