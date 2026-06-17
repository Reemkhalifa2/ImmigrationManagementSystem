package com.example.Immigration_Management_System_Demo.Services;

import DTO.OfficerDTO;
import com.example.Immigration_Management_System_Demo.Entities.BorderControlofficer;
import com.example.Immigration_Management_System_Demo.Entities.ImmigrationCenter;
import com.example.Immigration_Management_System_Demo.Entities.ImmigrationOfficer;
import com.example.Immigration_Management_System_Demo.Repository.CenterRepository;
import com.example.Immigration_Management_System_Demo.Repository.OfficerRepository;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ImmigrationOfficer register(ImmigrationOfficer immigrationOfficer){
        if(immigrationOfficer == null){
            throw new RuntimeException("Officer cannot be empty");
        }
        return officerRepository.save(immigrationOfficer);
    }

    public BorderControlofficer register(BorderControlofficer borderControlofficer){
        if(borderControlofficer == null){
            throw new RuntimeException("Officer cannot be empty");
        }
        return officerRepository.save(borderControlofficer);
    }

    public ImmigrationOfficer search(Long id){
        if(id==null){
            throw new RuntimeException("Id cannot be null");
        }
        ImmigrationOfficer immigrationOfficer = officerRepository.findById(id).orElseThrow(() -> new RuntimeException("officer not found"));
        return immigrationOfficer;
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

    public List<ImmigrationOfficer> findOfficersByRank(String rank){
        if(rank == null){
            throw new RuntimeException("Rank cannot be empty");
        }
        return officerRepository.findByOfficerRank(rank);
    }

    public List<OfficerDTO> findOfficersByRank(String rank, int minimumClearanceLevel){
        if(rank == null){
            throw new RuntimeException("Rank cannot be empty");
        }
        if(minimumClearanceLevel<0 || minimumClearanceLevel > 5){
            throw new RuntimeException("Clearance Level must be between 0 and 5");
        }
        return OfficerDTO.convertToDTO(officerRepository.findByOfficerRank(rank));
    }




}
