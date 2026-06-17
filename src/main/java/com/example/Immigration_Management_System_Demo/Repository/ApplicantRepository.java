package com.example.Immigration_Management_System_Demo.Repository;

import com.example.Immigration_Management_System_Demo.Entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    @Query("SELECT a FROM Applicant a")
    List<Applicant> getALl();
    @Query("SELECT a FROM Applicant a WHERE a.nationality =:nationality")
    List<Applicant> findByNationality(@Param("nationality") String nationality);
}
