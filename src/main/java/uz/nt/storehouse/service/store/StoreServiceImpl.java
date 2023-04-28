package uz.nt.storehouse.service.store;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.nt.storehouse.dto.store.StoreDto;
import uz.nt.storehouse.dto.user.UserDto;
import uz.nt.storehouse.entity.store.Store;
import uz.nt.storehouse.entity.user.User;
import uz.nt.storehouse.mapper.store.StoreMapper;
import uz.nt.storehouse.mapper.validator.AppStatusCodes;
import uz.nt.storehouse.mapper.validator.AppStatusMessages;
import uz.nt.storehouse.repository.store.StoreRepository;
import uz.nt.storehouse.response.ResponseDto;
import uz.nt.storehouse.service.base.AbstractService;
import uz.nt.storehouse.service.base.AssistCrudService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl extends AbstractService <
        StoreRepository,
        StoreMapper> implements StoreService, AssistCrudService<StoreDto, Long> {
    protected StoreServiceImpl(StoreRepository repository, StoreMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseDto<StoreDto> create(StoreDto dto) {
        Optional<Store> store = repository.findFirstByName(dto.getName());
        if(!store.isEmpty()){
            return ResponseDto.<StoreDto>builder()
                    .status(HttpStatus.OK.value())
                    .message(AppStatusMessages.DUPLICATE_ERROR)
                    .code(AppStatusCodes.DUPLICATE_ERROR_CODE)
                    .success(true)
                    .build();
        }
        Store newstore = mapper.toEntity(dto);
        repository.save(newstore);
        return ResponseDto.<StoreDto>builder()
                .message(AppStatusMessages.OK)
                .code(AppStatusCodes.OK_CODE)
                .success(true)
                .data(mapper.toDto(newstore))
                .status(HttpStatus.OK.value())
                .build();
    }

    @Override
    public ResponseDto<Void> delete(Long id) {

        Optional<Store> active = repository.findFirstByIdAndActive(id, (short) 1);
        if(active.isEmpty()){
            return ResponseDto.<Void>builder()
                    .status(HttpStatus.OK.value())
                    .code(AppStatusCodes.OK_CODE)
                    .success(true)
                    .message(AppStatusMessages.NOT_FOUND)
                    .build();
        }
        Store store = active.get();
        store.setActive((short) 0);
        repository.save(store);
        return ResponseDto.<Void>builder()
                .message(AppStatusMessages.OK)
                .code(AppStatusCodes.OK_CODE)
                .success(true)
                .status(HttpStatus.OK.value())
                .build();
    }

    @Override
    public ResponseDto<StoreDto> update(StoreDto dto) {
        if(dto.id == null){
            return ResponseDto.<StoreDto>builder()
                    .status(HttpStatus.OK.value())
                    .success(true)
                    .message(AppStatusMessages.NULL_VALUE)
                    .code(AppStatusCodes.OK_CODE)
                    .build();
        }
        Optional<Store> userOptional = repository.findFirstByIdAndActive(dto.id, (short) 1);
        if (userOptional.isEmpty()){
            return ResponseDto.<StoreDto>builder()
                    .status(HttpStatus.OK.value())
                    .success(true)
                    .code(AppStatusCodes.NOT_FOUND_ERROR_CODE)
                    .message(AppStatusMessages.NOT_FOUND)
                    .build();

        }
        Store store = userOptional.get();
        if (dto.getName() != null) {
            store.setName(dto.getName());
        }
        return ResponseDto.<StoreDto>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .code(AppStatusCodes.OK_CODE)
                .message(AppStatusMessages.OK)
                .data(mapper.toDto(store))
                .build();
    }

    @Override
    public ResponseDto<List<StoreDto>> getAll() {
        return ResponseDto.<List<StoreDto>>builder()
                .success(true)
                .message(AppStatusMessages.OK)
                .code(AppStatusCodes.OK_CODE)
                .data(repository.findAllByActive((short) 1).stream()
                        .map(u -> mapper.toDto(u))
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public ResponseDto<StoreDto> getById(Long id) {
        if(id == null){
            return ResponseDto.<StoreDto>builder()
                    .status(HttpStatus.OK.value())
                    .success(true)
                    .message(AppStatusMessages.NULL_VALUE)
                    .code(AppStatusCodes.OK_CODE)
                    .build();
        }
        Optional<Store> byId = repository.findById(id);
        if(byId.isEmpty()){
            return ResponseDto.<StoreDto>builder()
                    .status(HttpStatus.OK.value())
                    .success(true)
                    .code(AppStatusCodes.NOT_FOUND_ERROR_CODE)
                    .message(AppStatusMessages.NOT_FOUND)
                    .build();
        }
        Store store = byId.get();
        return ResponseDto.<StoreDto>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .message(AppStatusMessages.OK)
                .code(AppStatusCodes.OK_CODE)
                .data(mapper.toDto(store))
                .build();
    }
}
