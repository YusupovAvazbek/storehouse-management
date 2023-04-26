package uz.nt.storehouse.repository.store;

import org.springframework.stereotype.Repository;
import uz.nt.storehouse.entity.store.Store;
import uz.nt.storehouse.repository.base.AbstractRepository;
@Repository
public interface StoreRepository extends AbstractRepository<Store, Long> {
}
