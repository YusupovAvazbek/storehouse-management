package uz.nt.storehouse.entity.store;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.nt.storehouse.entity.base.Auditable;
import uz.nt.storehouse.entity.product.Product;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Store extends Auditable {
    private String name;

}
