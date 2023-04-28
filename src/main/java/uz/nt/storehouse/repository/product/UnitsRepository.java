package uz.nt.storehouse.repository.product;

import uz.nt.storehouse.entity.product.Units;
import uz.nt.storehouse.repository.base.AbstractRepository;

import java.util.List;
import java.util.Optional;

public interface UnitsRepository extends AbstractRepository<Units, Long> {
    Optional<Units> findFirstByName(String name);

    Optional<Units> findFirstByIdAndActive(Long id, short i);

    List<Units> findAllByActive(short i);
}
