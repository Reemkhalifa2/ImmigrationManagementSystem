package com.example.Immigration_Management_System_Demo.Repository;

import com.example.Immigration_Management_System_Demo.Entities.ImmigrationOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfficerRepository extends JpaRepository<ImmigrationOfficer , Long> {

    List<ImmigrationOfficer> findByRank(String rank);
    List<ImmigrationOfficer> findByRankAndClearanceLevelGreaterThanEqual(String rank, int clearanceLevel);
    List<ImmigrationOfficer> findByActive(boolean active);
    List<ImmigrationOfficer> findByCenterId(Long centerId);
}
