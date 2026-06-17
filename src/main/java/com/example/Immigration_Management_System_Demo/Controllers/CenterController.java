package com.example.Immigration_Management_System_Demo.Controllers;

import DTO.CenterDTO;
import com.example.Immigration_Management_System_Demo.Entities.ImmigrationCenter;
import com.example.Immigration_Management_System_Demo.Services.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("centers")
public class CenterController {

    CenterService centerService;
    @Autowired
    public CenterController(CenterService centerService) {
        this.centerService = centerService;
    }

    @PostMapping
    public ResponseEntity<ImmigrationCenter> register(@RequestBody ImmigrationCenter immigrationCenter){
        if(immigrationCenter == null){
            throw new RuntimeException("Center cannot be null");
        }
        return ResponseEntity.ok(centerService.register(immigrationCenter));
    }

    @GetMapping("search/{id}")
    public ResponseEntity<CenterDTO> search(@PathVariable Long id){
        return ResponseEntity.ok(centerService.search(id));
    }


}
