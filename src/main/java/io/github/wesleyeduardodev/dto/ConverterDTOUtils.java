package io.github.wesleyeduardodev.dto;
import io.github.wesleyeduardodev.entity.ConstructionEntity;
import io.github.wesleyeduardodev.entity.EngineerEntity;
import lombok.experimental.UtilityClass;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ConverterDTOUtils {

    public EngineerEntity convertEnginnerDTOToEnginnerEntity(EnginnerDTO enginnerDTO) {
        return EngineerEntity.builder()
                .id(enginnerDTO.getId())
                .name(enginnerDTO.getName())
                .wage(enginnerDTO.getWage())
                .age(enginnerDTO.getAge())
                .phone(enginnerDTO.getPhone())
                .build();
    }

    public EnginnerDTO convertEnginnerEntityToEnginnerDTO(EngineerEntity engineerEntity) {
        return EnginnerDTO.builder()
                .id(engineerEntity.getId())
                .name(engineerEntity.getName())
                .wage(engineerEntity.getWage())
                .age(engineerEntity.getAge())
                .phone(engineerEntity.getPhone())
                .idConstruction(engineerEntity.getConstructionEntity().getId())
                .build();
    }

    public ConstructionEntity convertConstructionDTOToConstructionsEntity(ContructionDTO contructionDTO) {
        return ConstructionEntity.builder()
                .id(contructionDTO.getId())
                .name(contructionDTO.getName())
                .phone(contructionDTO.getPhone())
                .email(contructionDTO.getEmail())
                .adress(contructionDTO.getAdress())
                .build();
    }

    public ContructionDTO convertConstructionEntityToConstructionsDTO(ConstructionEntity constructionEntity) {
        return ContructionDTO.builder()
                .id(constructionEntity.getId())
                .name(constructionEntity.getName())
                .phone(constructionEntity.getPhone())
                .email(constructionEntity.getEmail())
                .adress(constructionEntity.getAdress())
                .enginnerDTOS(converteEnginnerEntitiesToEnginnerDTOs(constructionEntity.getEngineerEntities()))
                .build();
    }

    private List<EnginnerDTO> converteEnginnerEntitiesToEnginnerDTOs(List<EngineerEntity> engineerEntities) {
        return engineerEntities
                .stream()
                .map(ConverterDTOUtils::convertEnginnerEntityToEnginnerDTO)
                .collect(Collectors.toList());
    }
}
