package com.example.Immigration_Management_System_Demo.Repository;

import com.example.Immigration_Management_System_Demo.Entities.ImmigrationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CenterRepository extends JpaRepository<ImmigrationCenter , Long> {
    @Query("SELECT c FROM ImmigrationCenter c WHERE c.id = :id")
    ImmigrationCenter getById(@Param("id") Long id);



}




