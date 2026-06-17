package com.example.Immigration_Management_System_Demo.Repository;

import com.example.Immigration_Management_System_Demo.Entities.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewRepository extends JpaRepository<Interview , Long> {
    List<Interview> findByOfficerIdAndInterviewDate(Long officerId, String interviewDate);

}
