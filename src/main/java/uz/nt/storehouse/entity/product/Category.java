package uz.nt.storehouse.entity.product;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import uz.nt.storehouse.entity.base.Auditable;
@Getter
@Setter
@Entity
public class Category extends Auditable {
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category parentCategory;
}
