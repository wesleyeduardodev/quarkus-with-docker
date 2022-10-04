package io.github.wesleyeduardodev.dto;
import io.github.wesleyeduardodev.entity.EngineerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import java.util.List;

@Data
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContructionDTO {

    private Long id;

    private String name;

    private String phone;

    private String adress;

    private String email;

    private List<EnginnerDTO> enginnerDTOS;
}
