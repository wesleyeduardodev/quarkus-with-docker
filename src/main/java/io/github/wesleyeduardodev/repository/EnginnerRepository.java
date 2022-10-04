package io.github.wesleyeduardodev.repository;
import io.github.wesleyeduardodev.entity.EngineerEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EnginnerRepository implements PanacheRepository<EngineerEntity> {}
