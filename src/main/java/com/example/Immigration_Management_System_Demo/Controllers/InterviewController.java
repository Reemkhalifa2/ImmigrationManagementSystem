package com.example.Immigration_Management_System_Demo.Controllers;

import DTO.InterviewDTO;
import com.example.Immigration_Management_System_Demo.Entities.Interview;
import com.example.Immigration_Management_System_Demo.Services.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @PostMapping("/schedule/{applicantId}/{officerId}")
    public ResponseEntity<Interview >scheduleInterview(
            @PathVariable Long applicantId,
            @PathVariable Long officerId,
            @RequestParam String date) {

        return ResponseEntity.ok(interviewService.scheduleInterview(applicantId, officerId, date));
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Interview> completeInterview(@PathVariable Long id) {
        return ResponseEntity.ok(interviewService.completeInterview(id));
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Interview> cancelInterview(@PathVariable Long id) {
        return ResponseEntity.ok(interviewService.cancelInterview(id));
    }

    @GetMapping("/officer/{officerId}/date/{date}")
    public ResponseEntity<List<InterviewDTO>> getOfficerSchedule(
            @PathVariable Long officerId,
            @PathVariable String date) {

        return ResponseEntity.ok(interviewService.getOfficerScheduleByDate(officerId, date));
    }
}
