package uz.nt.storehouse.entity.currency;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import uz.nt.storehouse.entity.base.Auditable;

@Getter
@Setter
@Entity
public class Currency extends Auditable {
    private String name;
    private String shortName;
}
