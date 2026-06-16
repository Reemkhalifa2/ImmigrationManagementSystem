package com.example.Immigration_Management_System_Demo.Services;

import com.example.Immigration_Management_System_Demo.Entities.ImmigrationCenter;
import com.example.Immigration_Management_System_Demo.Repository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterService {

    @Autowired
    public CenterService(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    CenterRepository centerRepository;

    public ImmigrationCenter register(ImmigrationCenter immigrationCenter){
        return centerRepository.save(immigrationCenter);
    }





}
