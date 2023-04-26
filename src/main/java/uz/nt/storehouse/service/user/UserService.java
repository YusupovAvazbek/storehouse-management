package uz.nt.storehouse.service.user;

import uz.nt.storehouse.dto.user.UserDto;
import uz.nt.storehouse.response.ResponseDto;
import uz.nt.storehouse.service.base.BaseCrudService;

import java.util.List;

public interface UserService extends BaseCrudService<UserDto, Long> {
    ResponseDto<List<UserDto>> getAll();
}
