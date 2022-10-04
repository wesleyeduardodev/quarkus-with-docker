package io.github.wesleyeduardodev.entity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "construction")
public class ConstructionEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    private String adress;

    private String email;

    @OneToMany(mappedBy = "constructionEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EngineerEntity> engineerEntities;
}
