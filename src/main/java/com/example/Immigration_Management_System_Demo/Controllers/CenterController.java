package com.example.Immigration_Management_System_Demo.Controllers;

import com.example.Immigration_Management_System_Demo.Entities.Applicant;
import com.example.Immigration_Management_System_Demo.Entities.AsylumSeeker;
import com.example.Immigration_Management_System_Demo.Entities.ImmigrationCenter;
import com.example.Immigration_Management_System_Demo.Services.ApplicantService;
import com.example.Immigration_Management_System_Demo.Services.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("centers")
public class CenterController {

    CenterService centerService;
    @Autowired
    public CenterController(CenterService centerService) {
        this.centerService = centerService;
    }

    @PostMapping
    public ImmigrationCenter register(@RequestBody ImmigrationCenter immigrationCenter){
        if(immigrationCenter == null){
            throw new RuntimeException("Center cannot be null");
        }
        return centerService.register(immigrationCenter);
    }

    @GetMapping("search/{id}")
    public ImmigrationCenter search(@PathVariable Long id){
        return centerService.search(id);
    }


}
