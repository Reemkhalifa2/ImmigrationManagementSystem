package com.example.Immigration_Management_System_Demo.Controllers;

import DTO.OfficerDTO;
import com.example.Immigration_Management_System_Demo.Entities.BorderControlofficer;
import com.example.Immigration_Management_System_Demo.Entities.ImmigrationOfficer;
import com.example.Immigration_Management_System_Demo.Services.OfficerService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.AudioFileFormat;
import java.util.List;

@RestController
@RequestMapping("officers")
public class OfficerController {
    @Autowired
    public OfficerController(OfficerService officerService) {
        this.officerService = officerService;
    }

    OfficerService officerService;

    @PostMapping
    public ResponseEntity<ImmigrationOfficer> register(@RequestBody ImmigrationOfficer immigrationOfficer){
        return ResponseEntity.ok(officerService.register(immigrationOfficer));
    }

    @PostMapping("border")
    public ResponseEntity<ImmigrationOfficer> register(@RequestBody BorderControlofficer borderControlofficer){
        return ResponseEntity.ok(officerService.register(borderControlofficer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImmigrationOfficer> search(@PathVariable Long id){
        return ResponseEntity.ok(officerService.search(id));
    }

    @GetMapping("/rank")
    public ResponseEntity<List<OfficerDTO> >findOfficersByRank(@RequestParam String rank, @RequestParam int minimumClearanceLevel){
        return ResponseEntity.ok(officerService.findOfficersByRank(rank,minimumClearanceLevel));
    }

    @PutMapping("promote/{id}")
    public ResponseEntity< ImmigrationOfficer >promoteOfficer(@PathVariable Long id , @RequestParam String newRank, @RequestParam Integer clearance){
        return ResponseEntity.ok(officerService.promoteOfficer(id,newRank,clearance));
    }

    @PutMapping("transfer/{id}")
    public ResponseEntity<ImmigrationOfficer> promoteOfficer(@PathVariable Long id , @RequestParam Long centerId){
        return ResponseEntity.ok(officerService.transferOfficer(id,centerId));
    }








}
