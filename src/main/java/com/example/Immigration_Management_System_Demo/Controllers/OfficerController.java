package com.example.Immigration_Management_System_Demo.Controllers;

import com.example.Immigration_Management_System_Demo.Entities.BorderControlofficer;
import com.example.Immigration_Management_System_Demo.Entities.ImmigrationOfficer;
import com.example.Immigration_Management_System_Demo.Services.OfficerService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ImmigrationOfficer register(@RequestBody ImmigrationOfficer immigrationOfficer){
        return officerService.register(immigrationOfficer);
    }

    @PostMapping("border")
    public ImmigrationOfficer register(@RequestBody BorderControlofficer borderControlofficer){
        return officerService.register(borderControlofficer);
    }

    @GetMapping("/{id}")
    public ImmigrationOfficer search(@PathVariable Long id){
        return officerService.search(id);
    }

    @PutMapping("promote/{id}")
    public ImmigrationOfficer promoteOfficer(@PathVariable Long id , @RequestParam String newRank, @RequestParam Integer clearance){
        return officerService.promoteOfficer(id,newRank,clearance);
    }

    @PutMapping("transfer/{id}")
    public ImmigrationOfficer promoteOfficer(@PathVariable Long id , @RequestParam Long centerId){
        return officerService.transferOfficer(id,centerId);
    }






}
