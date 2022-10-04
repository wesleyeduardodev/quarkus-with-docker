package io.github.wesleyeduardodev.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import java.math.BigDecimal;

@Data
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnginnerDTO {

    private Long id;

    private String name;

    private BigDecimal wage;

    private Integer age;

    private String phone;

    private Long idConstruction;
}
