package DTO;

import com.example.Immigration_Management_System_Demo.Entities.Applicant;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ApplicantDTO {
    private String name;
    private String nationality;
    private String passportNumber;
    private Boolean criminalRecord;


    public static ApplicantDTO convertToDTO(Applicant entity) {
        ApplicantDTO dto = new ApplicantDTO();
        dto.setName(entity.getFirstName() +" "+entity.getLastName());
        dto.setPassportNumber(entity.getPassportNumber());
        dto.setNationality(entity.getNationality());
        dto.setCriminalRecord(entity.getCriminalRecord());
        return dto;
    }

    public static List<ApplicantDTO> convertToDTO(List<Applicant> entities) {
        List<ApplicantDTO> dtos = new ArrayList<>();

        for (Applicant entity : entities) {
            dtos.add(convertToDTO(entity));
        }

        return dtos;
    }
}
