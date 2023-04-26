package uz.nt.storehouse.rest.user;

import org.springframework.web.bind.annotation.*;
import uz.nt.storehouse.dto.user.LoginDto;
import uz.nt.storehouse.dto.user.UserDto;
import uz.nt.storehouse.response.ResponseDto;
import uz.nt.storehouse.rest.base.AbstractResources;
import uz.nt.storehouse.service.user.UserServiceImpl;

import java.util.List;

@RequestMapping("api/user")
public class UserResources extends AbstractResources<UserServiceImpl> {
    public UserResources(UserServiceImpl service){
        super(service);
    }
    @GetMapping("get-all-users")
    public ResponseDto<List<UserDto>> getAllUsers(){
        return service.getAll();
    }
    @PostMapping()
    public ResponseDto<UserDto> create(@RequestBody UserDto userDto){
        return service.create(userDto);
    }
    @PatchMapping("update-user")
    public ResponseDto<UserDto> update(@RequestBody UserDto userDto){
        return service.update(userDto);
    }
    @DeleteMapping()
    public ResponseDto<Void> delete(@RequestParam Long id){
        return service.delete(id);
    }
    @PostMapping("login")
    public ResponseDto<String> login(LoginDto loginDto){
        return service.login(loginDto);
    }
}
