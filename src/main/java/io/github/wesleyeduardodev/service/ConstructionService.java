package io.github.wesleyeduardodev.service;
import io.github.wesleyeduardodev.dto.ContructionDTO;
import io.github.wesleyeduardodev.dto.ConverterDTOUtils;
import io.github.wesleyeduardodev.entity.ConstructionEntity;
import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class ConstructionService {

    public List<ContructionDTO> findAllConstructions() {
        List<ConstructionEntity> constructionEntities = ConstructionEntity.listAll();
        List<ContructionDTO> contructionDTOS = new ArrayList<>();
        constructionEntities.forEach(constructionEntity -> contructionDTOS.add(ConverterDTOUtils.convertConstructionEntityToConstructionsDTO(constructionEntity)));
        return contructionDTOS;
    }

    public ContructionDTO findConstructionById(Long id) {
        ConstructionEntity constructionEntity = ConstructionEntity.findById(id);
        return Objects.isNull(constructionEntity) ? null :ConverterDTOUtils.convertConstructionEntityToConstructionsDTO(constructionEntity);
    }

    public void createNewConstruction(ContructionDTO contructionDTO) {
        ConstructionEntity.persist(ConverterDTOUtils.convertConstructionDTOToConstructionsEntity(contructionDTO));
    }

    public void changeConstruction(Long id, ContructionDTO contructionDTO) {
        ConstructionEntity constructionEntity = ConstructionEntity.findById(id);
        constructionEntity.setName(contructionDTO.getName());
        constructionEntity.setEmail(contructionDTO.getEmail());
        constructionEntity.setPhone(contructionDTO.getPhone());
        constructionEntity.setEmail(contructionDTO.getEmail());
        constructionEntity.setAdress(contructionDTO.getAdress());
        ConstructionEntity.persist(constructionEntity);
    }

    public void deleteConstruction(Long id) {
        ConstructionEntity.deleteById(id);
    }
}
