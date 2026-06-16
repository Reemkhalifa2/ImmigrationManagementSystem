package com.example.Immigration_Management_System_Demo.Services;

import com.example.Immigration_Management_System_Demo.Entities.ImmigrationCenter;
import com.example.Immigration_Management_System_Demo.Entities.ImmigrationOfficer;
import com.example.Immigration_Management_System_Demo.Repository.CenterRepository;
import com.example.Immigration_Management_System_Demo.Repository.OfficerRepository;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficerService {

    private final OfficerRepository officerRepository;
    private final CenterRepository centerRepository;

    @Autowired
    public OfficerService(
            OfficerRepository officerRepository,
            CenterRepository centerRepository
    ) {
        this.officerRepository = officerRepository;
        this.centerRepository = centerRepository;
    }

    public ImmigrationOfficer promoteOfficer(@NotBlank(message = "id cannot be null") Long officerId, String newRank, int newClearanceLevel){
        ImmigrationOfficer immigrationOfficer = officerRepository.getById(officerId);
        if(immigrationOfficer == null){
            throw new RuntimeException("officer not found");
        }
        if(newRank.equalsIgnoreCase(immigrationOfficer.getOfficerRank())
        || newClearanceLevel == immigrationOfficer.getClearanceLevel()){
            throw new RuntimeException("Invalid Data");
        }
        immigrationOfficer.setOfficerRank(newRank);
        immigrationOfficer.setClearanceLevel(newClearanceLevel);
        return officerRepository.save(immigrationOfficer);

    }

    public ImmigrationOfficer transferOfficer(Long officerId, Long newCenterId) {
        ImmigrationOfficer officer = officerRepository.getById(officerId);
        ImmigrationCenter center = centerRepository.findById(newCenterId)
                .orElseThrow(() -> new RuntimeException("Center not found with id: " + newCenterId));
        officer.setCenter(center);
        return officerRepository.save(officer);
    }




}
