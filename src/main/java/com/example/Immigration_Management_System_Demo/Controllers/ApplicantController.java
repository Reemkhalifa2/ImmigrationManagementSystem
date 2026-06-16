package com.example.Immigration_Management_System_Demo.Controllers;

import com.example.Immigration_Management_System_Demo.Entities.Applicant;
import com.example.Immigration_Management_System_Demo.Entities.AsylumSeeker;
import com.example.Immigration_Management_System_Demo.Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("applicants")
public class ApplicantController {
    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }
    ApplicantService applicantService;


    @PostMapping("register")
    public Applicant saveApplicant(@RequestBody  Applicant applicant){
        return applicantService.saveApplicant(applicant);
    }
    @PostMapping("register/applicant")
    public Applicant saveApplicant(@RequestParam String firstName, @RequestParam String lastName,@RequestParam String passportNumber,@RequestParam String
            nationality){
        return applicantService.saveApplicant(firstName, lastName, passportNumber, nationality);
    }
    @PostMapping("register/asylum-seeker")
    public AsylumSeeker saveApplicant(@RequestBody AsylumSeeker asylumSeeker){
        return applicantService.saveApplicant(asylumSeeker);
    }
    @GetMapping()
    public List<Applicant> getAll(){
        return applicantService.getAll();
    }
    @GetMapping("search")
    public List<Applicant> search(@RequestParam String nationality){
        return applicantService.search(nationality);
    }














}
