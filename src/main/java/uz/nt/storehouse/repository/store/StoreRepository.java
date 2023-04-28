package uz.nt.storehouse.repository.store;

import org.springframework.stereotype.Repository;
import uz.nt.storehouse.entity.store.Store;
import uz.nt.storehouse.entity.user.User;
import uz.nt.storehouse.repository.base.AbstractRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository extends AbstractRepository<Store, Long> {
    Optional<Store> findFirstByIdAndActive(Long id, short isActive);
    List<Store> findAllByActive(short activeCode);
    Optional<Store> findFirstByName(String storeName);
}
