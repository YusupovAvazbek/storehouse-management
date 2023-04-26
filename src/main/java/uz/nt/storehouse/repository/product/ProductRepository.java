package uz.nt.storehouse.repository.product;

import org.springframework.stereotype.Repository;
import uz.nt.storehouse.entity.product.Product;
import uz.nt.storehouse.repository.base.AbstractRepository;
@Repository
public interface ProductRepository extends AbstractRepository<Product, Long> {
}
