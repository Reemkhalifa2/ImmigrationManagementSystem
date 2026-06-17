package com.example.Immigration_Management_System_Demo.Controllers;

import DTO.ApplicantDTO;
import com.example.Immigration_Management_System_Demo.Entities.Applicant;
import com.example.Immigration_Management_System_Demo.Entities.AsylumSeeker;
import com.example.Immigration_Management_System_Demo.Services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Applicant>saveApplicant(@RequestBody  Applicant applicant){
        return ResponseEntity.ok(applicantService.saveApplicant(applicant));
    }
    @PostMapping("register/applicant")
    public ResponseEntity<Applicant> saveApplicant(@RequestParam String firstName, @RequestParam String lastName,@RequestParam String passportNumber,@RequestParam String
            nationality){
        return ResponseEntity.ok(applicantService.saveApplicant(firstName, lastName, passportNumber, nationality));
    }
    @PostMapping("register/asylum-seeker")
    public ResponseEntity<AsylumSeeker> saveApplicant(@RequestBody AsylumSeeker asylumSeeker){
        return ResponseEntity.ok(applicantService.saveApplicant(asylumSeeker));
    }
    @GetMapping()
    public ResponseEntity<List<ApplicantDTO>> getAll(){
        return ResponseEntity.ok(applicantService.getAll());
    }
    @GetMapping("search")
    public ResponseEntity<List<ApplicantDTO>> search(@RequestParam String nationality){
        return ResponseEntity.ok(applicantService.search(nationality));
    }


    @PutMapping("flag/{id}")
    public ResponseEntity<Applicant> flag(@PathVariable Long id){
        return ResponseEntity.ok(applicantService.flagCriminalRecord(id));
    }














}
