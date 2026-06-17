package DTO;


import com.example.Immigration_Management_System_Demo.Controllers.CenterController;
import com.example.Immigration_Management_System_Demo.Entities.ImmigrationCenter;
import com.example.Immigration_Management_System_Demo.Entities.ImmigrationOfficer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CenterDTO {

    private String name;
    private String locationCountry;

    public static CenterDTO convertToDTO(ImmigrationCenter entity) {
        CenterDTO dto = new CenterDTO();
        dto.setName(entity.getName());
        dto.setLocationCountry(entity.getLocationCountry());
        return dto;

    }

    public static List<CenterDTO> convertToDTO(List<ImmigrationCenter> entities) {
        List<CenterDTO> dtos = new ArrayList<>();
        for (ImmigrationCenter entity : entities) {
            dtos.add(convertToDTO(entity));
        }
        return dtos;
    }





}
