package DTO;

import com.example.Immigration_Management_System_Demo.Entities.Applicant;
import com.example.Immigration_Management_System_Demo.Entities.ImmigrationOfficer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class OfficerDTO {
    private String name;
    private String badgeNumber;


    public static OfficerDTO convertToDTO(ImmigrationOfficer entity) {
        OfficerDTO dto = new OfficerDTO();
        dto.setName(entity.getFirstName() +" "+entity.getLastName());
        dto.setBadgeNumber(entity.getBadgeNumber());
        return dto;
    }

    public static List<OfficerDTO> convertToDTO(List<ImmigrationOfficer> entities) {
        List<OfficerDTO> dtos = new ArrayList<>();

        for (ImmigrationOfficer entity : entities) {
            dtos.add(convertToDTO(entity));
        }

        return dtos;
    }


}
