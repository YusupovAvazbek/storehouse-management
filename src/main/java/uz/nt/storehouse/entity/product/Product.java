package uz.nt.storehouse.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import uz.nt.storehouse.entity.base.Auditable;
import uz.nt.storehouse.entity.store.Store;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends Auditable {
    private String name;
    private String description;
    private Double price;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    private Units unit;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Store store;
}
