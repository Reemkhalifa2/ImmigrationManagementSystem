package com.example.Immigration_Management_System_Demo.Services;

import com.example.Immigration_Management_System_Demo.Repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterviewService {
    @Autowired
    public InterviewService(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    InterviewRepository interviewRepository;






}
