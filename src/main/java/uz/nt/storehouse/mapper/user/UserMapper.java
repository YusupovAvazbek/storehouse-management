package uz.nt.storehouse.mapper.user;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.nt.storehouse.dto.user.UserDto;
import uz.nt.storehouse.entity.user.User;
import uz.nt.storehouse.mapper.base.AbstractMapper;
@Component
@Mapper(componentModel = "spring")
public abstract class UserMapper implements AbstractMapper<User, UserDto> {

    @Override
    abstract public UserDto toDto(User entity);

    @Override
    abstract public User toEntity(UserDto dto);
}
