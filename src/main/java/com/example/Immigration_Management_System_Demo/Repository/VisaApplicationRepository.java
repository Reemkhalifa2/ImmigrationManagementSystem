package com.example.Immigration_Management_System_Demo.Repository;

import com.example.Immigration_Management_System_Demo.Entities.VisaApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisaApplicationRepository extends JpaRepository<VisaApplication, Long> {
    List<VisaApplication> findByApplicantId(Long applicantId);
    List<VisaApplication> findByStatus(String status);
    List<VisaApplication> findByVisaType(String visaType);
    List<VisaApplication> findByHandlingOfficerId(Long officerId);
}
