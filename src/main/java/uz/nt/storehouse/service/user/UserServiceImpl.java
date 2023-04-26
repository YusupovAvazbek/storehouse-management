package uz.nt.storehouse.service.user;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.nt.storehouse.dto.user.LoginDto;
import uz.nt.storehouse.dto.user.UserDto;
import uz.nt.storehouse.entity.user.User;
import uz.nt.storehouse.mapper.user.UserMapper;
import uz.nt.storehouse.mapper.validator.AppStatusCodes;
import uz.nt.storehouse.mapper.validator.AppStatusMessages;
import uz.nt.storehouse.repository.user.UserRepository;
import uz.nt.storehouse.response.ResponseDto;
import uz.nt.storehouse.service.base.AbstractService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractService<
        UserRepository,
        UserMapper> implements UserService{


    protected UserServiceImpl(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseDto<UserDto> create(UserDto dto) {
        User user = mapper.toEntity(dto);
        repository.save(user);
        return ResponseDto.<UserDto>builder()
                .message(AppStatusMessages.OK)
                .code(AppStatusCodes.OK_CODE)
                .success(true)
                .data(mapper.toDto(user))
                .status(HttpStatus.OK.value())
                .build();
    }

    @Override
    public ResponseDto<Void> delete(Long id) {
        Optional<User> active = repository.findFirstByIdAndActive(id, (short) 1);
        if(active.isEmpty()){
            return ResponseDto.<Void>builder()
                    .status(HttpStatus.OK.value())
                    .code(AppStatusCodes.OK_CODE)
                    .success(true)
                    .message(AppStatusMessages.NOT_FOUND)
                    .build();
        }
        User user = active.get();
        user.setActive((short) 0);
        repository.save(user);
        return ResponseDto.<Void>builder()
                .message(AppStatusMessages.OK)
                .code(AppStatusCodes.OK_CODE)
                .success(true)
                .status(HttpStatus.OK.value())
                .build();
    }

    @Override
    public ResponseDto<UserDto> update(UserDto dto) {
        if(dto.id == null){
            return ResponseDto.<UserDto>builder()
                    .status(HttpStatus.OK.value())
                    .success(true)
                    .message(AppStatusMessages.NULL_VALUE)
                    .code(AppStatusCodes.OK_CODE)
                    .build();
        }
        Optional<User> userOptional = repository.findFirstByIdAndActive(dto.id, (short) 1);
        if(userOptional.isEmpty()){
            return ResponseDto.<UserDto>builder()
                    .status(HttpStatus.OK.value())
                    .success(true)
                    .code(AppStatusCodes.NOT_FOUND_ERROR_CODE)
                    .message(AppStatusMessages.NOT_FOUND)
                    .build();

        }
        User updateUser = userOptional.get();
        if(dto.getFullName() != null){
            updateUser.setFullName(dto.getFullName());
        }if(dto.getPhoneNumber() != null){
            updateUser.setPhoneNumber(dto.getPhoneNumber());
        }if(dto.getEmail() != null){
            updateUser.setEmail(dto.getEmail());
        }

        repository.save(updateUser);
        return ResponseDto.<UserDto>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .message(AppStatusMessages.OK)
                .code(AppStatusCodes.OK_CODE)
                .data(mapper.toDto(updateUser))
                .build();
    }

    @Override
    public ResponseDto<List<UserDto>> getAll() {
        return ResponseDto.<List<UserDto>>builder()
                .success(true)
                .message(AppStatusMessages.OK)
                .code(AppStatusCodes.OK_CODE)
                .data(repository.findAllByActive((short) 1).stream()
                        .map(u -> mapper.toDto(u))
                        .collect(Collectors.toList()))
                .build();
    }

    public ResponseDto<String> login(LoginDto loginDto) {
        return null;
    }
}
