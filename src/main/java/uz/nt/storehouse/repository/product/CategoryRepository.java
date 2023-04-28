package uz.nt.storehouse.repository.product;

import uz.nt.storehouse.entity.product.Category;
import uz.nt.storehouse.entity.product.Units;
import uz.nt.storehouse.repository.base.AbstractRepository;

import java.util.Optional;

public interface CategoryRepository extends AbstractRepository<Category, Long> {
    Optional<Category> findFirstByName(String name);

    Optional<Category> findFirstByIdAndActive(Long id, short i);
}
