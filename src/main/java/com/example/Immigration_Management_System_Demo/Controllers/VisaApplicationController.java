package com.example.Immigration_Management_System_Demo.Controllers;

import com.example.Immigration_Management_System_Demo.Entities.VisaApplication;
import com.example.Immigration_Management_System_Demo.Services.VisaApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("visas")
public class VisaApplicationController {

    @Autowired
    public VisaApplicationController(VisaApplicationService visaApplicationService) {
        this.visaApplicationService = visaApplicationService;
    }

    VisaApplicationService visaApplicationService;

    @PostMapping("/submit/{applicantId}")
    public ResponseEntity<VisaApplication> submitVisa(
            @PathVariable Long applicantId,
            @RequestParam String type) {

        return ResponseEntity.ok(visaApplicationService.submitApplication(applicantId, type));
    }


    @PutMapping("/{visaId}/assign/{officerId}")
    public ResponseEntity<VisaApplication> assignOfficer(
            @PathVariable Long visaId,
            @PathVariable Long officerId) {

        return ResponseEntity.ok(visaApplicationService.assignReviewOfficer(visaId, officerId));
    }


    @PutMapping("/{visaId}/process")
    public ResponseEntity<VisaApplication> processVisa(
            @PathVariable Long visaId,
            @RequestParam String status,
            @RequestParam String notes) {

        return ResponseEntity.ok(visaApplicationService.processVisa(visaId, status, notes));
    }

    @GetMapping("/applicant/{applicantId}")
    public ResponseEntity<List<VisaApplication>> getVisasByApplicant(
            @PathVariable Long applicantId) {

        return ResponseEntity.ok(visaApplicationService.getVisasByApplicant(applicantId));
    }


    @GetMapping("/status/{status}")
    public ResponseEntity<List<VisaApplication>> getVisasByStatus(
            @PathVariable String status) {

        return ResponseEntity.ok(visaApplicationService.getVisasByStatus(status));
    }


}
