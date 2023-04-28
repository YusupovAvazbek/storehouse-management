package uz.nt.storehouse.repository.user;

import org.mapstruct.control.MappingControl;
import uz.nt.storehouse.dto.user.UserDto;
import uz.nt.storehouse.entity.user.User;
import uz.nt.storehouse.repository.base.AbstractRepository;

import java.util.Optional;
import java.util.List;

public interface UserRepository extends AbstractRepository<User, Long> {
    Optional<User> findFirstByIdAndActive(Long id, short activeCode);
    List<User> findAllByActive(short activeCode);
    Optional<User> findFirstByUsername(String username);
}
