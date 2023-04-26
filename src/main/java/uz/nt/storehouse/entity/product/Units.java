package uz.nt.storehouse.entity.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;
import uz.nt.storehouse.entity.base.Auditable;

@Getter
@Setter
@Entity
public class Units extends Auditable {
    private String name;
    private String shortName;

}
