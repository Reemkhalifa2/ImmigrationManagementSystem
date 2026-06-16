package com.example.Immigration_Management_System_Demo.Repository;

import com.example.Immigration_Management_System_Demo.Entities.ImmigrationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CenterRepository extends JpaRepository<ImmigrationCenter , Long> {

}




