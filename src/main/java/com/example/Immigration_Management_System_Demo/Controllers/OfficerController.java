package com.example.Immigration_Management_System_Demo.Controllers;

import com.example.Immigration_Management_System_Demo.Entities.ImmigrationOfficer;
import com.example.Immigration_Management_System_Demo.Services.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.AudioFileFormat;

@RestController
@RequestMapping("officers")
public class OfficerController {
    @Autowired
    public OfficerController(OfficerService officerService) {
        this.officerService = officerService;
    }

    OfficerService officerService;

    


}
