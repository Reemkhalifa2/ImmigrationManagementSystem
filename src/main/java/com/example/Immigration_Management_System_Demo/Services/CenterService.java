package com.example.Immigration_Management_System_Demo.Services;

import DTO.CenterDTO;
import com.example.Immigration_Management_System_Demo.Entities.ImmigrationCenter;
import com.example.Immigration_Management_System_Demo.Exceptions.GenericException;
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
        if(immigrationCenter == null){
            throw new GenericException(
                    "Immigration Center cannot be null");
        }
        return centerRepository.save(immigrationCenter);
    }

    public CenterDTO search(Long id) {
        if(id == null){
            throw new GenericException("Id cannot be null");
        }
        return CenterDTO.convertToDTO(centerRepository.getById(id));

    }




}
