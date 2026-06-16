package com.example.Immigration_Management_System_Demo.Controllers;

import com.example.Immigration_Management_System_Demo.Entities.VisaApplication;
import com.example.Immigration_Management_System_Demo.Services.VisaApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public VisaApplication submitVisa(
            @PathVariable Long applicantId,
            @RequestParam String type) {

        return visaApplicationService.submitApplication(applicantId, type);
    }


    @PutMapping("/{visaId}/assign/{officerId}")
    public VisaApplication assignOfficer(
            @PathVariable Long visaId,
            @PathVariable Long officerId) {

        return visaApplicationService.assignReviewOfficer(visaId, officerId);
    }


    @PutMapping("/{visaId}/process")
    public VisaApplication processVisa(
            @PathVariable Long visaId,
            @RequestParam String status,
            @RequestParam String notes) {

        return visaApplicationService.processVisa(visaId, status, notes);
    }

    @GetMapping("/applicant/{applicantId}")
    public List<VisaApplication> getVisasByApplicant(
            @PathVariable Long applicantId) {

        return visaApplicationService.getVisasByApplicant(applicantId);
    }


    @GetMapping("/status/{status}")
    public List<VisaApplication> getVisasByStatus(
            @PathVariable String status) {

        return visaApplicationService.getVisasByStatus(status);
    }


}
