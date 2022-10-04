package io.github.wesleyeduardodev.repository;
import io.github.wesleyeduardodev.entity.ConstructionEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConstructionRepository implements PanacheRepository<ConstructionEntity> {}
