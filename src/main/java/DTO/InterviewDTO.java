package DTO;

import com.example.Immigration_Management_System_Demo.Entities.ImmigrationCenter;
import com.example.Immigration_Management_System_Demo.Entities.Interview;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class InterviewDTO {
    private String interviewDate;
    private String status;

    public static InterviewDTO convertToDTO(Interview entity) {
        InterviewDTO dto = new InterviewDTO();
        dto.setInterviewDate(entity.getInterviewDate());
        dto.setStatus(entity.getStatus());
        return dto;

    }

    public static List<InterviewDTO> convertToDTO(List<Interview> entities) {
        List<InterviewDTO> dtos = new ArrayList<>();
        for (Interview entity : entities) {
            dtos.add(convertToDTO(entity));
        }
        return dtos;
    }

}
