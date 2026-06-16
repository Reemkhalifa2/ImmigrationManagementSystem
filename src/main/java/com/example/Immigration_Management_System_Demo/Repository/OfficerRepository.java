package com.example.Immigration_Management_System_Demo.Repository;

import com.example.Immigration_Management_System_Demo.Entities.ImmigrationOfficer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OfficerRepository extends JpaRepository<ImmigrationOfficer , Long> {

    @Query("SELECT i from ImmigrationOfficer i where i.id=:id And i.active = true")
    ImmigrationOfficer getById(@Param("id") Long id);

    List<ImmigrationOfficer> findByOfficerRank(@Param("officerRank") String officerRank);
}
