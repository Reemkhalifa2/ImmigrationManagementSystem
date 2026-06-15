package com.example.Immigration_Management_System_Demo.Repository;

import com.example.Immigration_Management_System_Demo.Entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    @Query("Select a from applicant where a.nationality=:nationality")
    List<Applicant> findByNationality(@Param("nationality") String nationality);
}
