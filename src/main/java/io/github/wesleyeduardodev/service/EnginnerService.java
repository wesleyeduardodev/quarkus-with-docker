package io.github.wesleyeduardodev.service;
import io.github.wesleyeduardodev.dto.ConverterDTOUtils;
import io.github.wesleyeduardodev.dto.EnginnerDTO;
import io.github.wesleyeduardodev.entity.ConstructionEntity;
import io.github.wesleyeduardodev.entity.EngineerEntity;
import javax.enterprise.context.ApplicationScoped;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class EnginnerService {
    public List<EnginnerDTO> findAllEnginners() {
        List<EngineerEntity> engineerEntities = EngineerEntity.listAll();
        return engineerEntities
                .stream()
                .map(ConverterDTOUtils::convertEnginnerEntityToEnginnerDTO)
                .sorted(Comparator.comparing(EnginnerDTO::getId))
                .collect(Collectors.toList());
    }

    public EnginnerDTO findEnginnerById(Long id) {
        EngineerEntity engineerEntity = EngineerEntity.findById(id);
        return Objects.isNull(engineerEntity) ? null :ConverterDTOUtils.convertEnginnerEntityToEnginnerDTO(engineerEntity);
    }

    public void createNewEnginner(EnginnerDTO enginnerDTO) {
        ConstructionEntity constructionEntity = ConstructionEntity.findById(enginnerDTO.getIdConstruction());
        EngineerEntity engineerEntity = ConverterDTOUtils.convertEnginnerDTOToEnginnerEntity(enginnerDTO);
        engineerEntity.setConstructionEntity(constructionEntity);
        EngineerEntity.persist(engineerEntity);
    }

    public void changeEnginner(Long id, EnginnerDTO enginnerDTO) {
        EngineerEntity engineerEntity = EngineerEntity.findById(id);
        engineerEntity.setName(enginnerDTO.getName());
        engineerEntity.setWage(enginnerDTO.getWage());
        engineerEntity.setAge(enginnerDTO.getAge());
        engineerEntity.setPhone(enginnerDTO.getPhone());
        EngineerEntity.persist(engineerEntity);
    }

    public void deleteEnginner(Long id) {
        EngineerEntity.deleteById(id);
    }
}
