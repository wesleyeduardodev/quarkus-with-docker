package io.github.wesleyeduardodev.entity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "engineer")
public class EngineerEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal wage;

    private Integer age;

    private String phone;

    @ManyToOne
    @JoinColumn(name="id_construction", referencedColumnName = "id")
    private ConstructionEntity constructionEntity;
}
