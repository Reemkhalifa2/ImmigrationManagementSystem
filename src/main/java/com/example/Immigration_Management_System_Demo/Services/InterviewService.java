package com.example.Immigration_Management_System_Demo.Services;

import DTO.InterviewDTO;
import com.example.Immigration_Management_System_Demo.Entities.Applicant;
import com.example.Immigration_Management_System_Demo.Entities.ImmigrationOfficer;
import com.example.Immigration_Management_System_Demo.Entities.Interview;
import com.example.Immigration_Management_System_Demo.Exceptions.GenericException;
import com.example.Immigration_Management_System_Demo.Repository.ApplicantRepository;
import com.example.Immigration_Management_System_Demo.Repository.InterviewRepository;
import com.example.Immigration_Management_System_Demo.Repository.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private OfficerRepository officerRepository;

    public Interview scheduleInterview(Long applicantId, Long officerId, String date) {

        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));

        ImmigrationOfficer officer = officerRepository.findById(officerId)
                .orElseThrow(() -> new RuntimeException("Officer not found"));

        List<Interview> existing =
                interviewRepository.findByOfficerIdAndInterviewDate(officerId, date);

        if (!existing.isEmpty()) {
            throw new RuntimeException("Officer is double-booked!");
        }

        Interview interview = new Interview();
        interview.setApplicant(applicant);
        interview.setImmigrationOfficer(officer);
        interview.setInterviewDate(date);
        interview.setStatus("SCHEDULED");

        return interviewRepository.save(interview);
    }

    public Interview completeInterview(Long interviewId) {

        Interview interview = interviewRepository.findById(interviewId)
                .orElseThrow(() -> new GenericException("Interview not found"));

        interview.setStatus("COMPLETED");

        return interviewRepository.save(interview);
    }

    public Interview cancelInterview(Long interviewId) {

        Interview interview = interviewRepository.findById(interviewId)
                .orElseThrow(() -> new GenericException("Interview not found"));

        interview.setStatus("CANCELLED");

        return interviewRepository.save(interview);
    }

    public List<InterviewDTO> getOfficerSchedule(Long officerId, String date) {

        return InterviewDTO.convertToDTO(interviewRepository.findByOfficerIdAndInterviewDate(officerId, date));
    }

    public Interview getInterviewById(Long id) {

        return interviewRepository.findById(id)
                .orElseThrow(() -> new GenericException("Interview not found"));
    }
}