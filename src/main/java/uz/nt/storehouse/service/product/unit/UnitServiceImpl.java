package uz.nt.storehouse.service.product.unit;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.nt.storehouse.dto.product.UnitsDto;
import uz.nt.storehouse.entity.product.Units;
import uz.nt.storehouse.mapper.product.UnitMapper;
import uz.nt.storehouse.mapper.validator.AppStatusCodes;
import uz.nt.storehouse.mapper.validator.AppStatusMessages;
import uz.nt.storehouse.repository.product.UnitsRepository;
import uz.nt.storehouse.response.ResponseDto;
import uz.nt.storehouse.service.base.AbstractService;
import uz.nt.storehouse.service.base.AssistCrudService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UnitServiceImpl extends AbstractService<
        UnitsRepository,
        UnitMapper
        > implements UnitService, AssistCrudService<UnitsDto, Long> {
    protected UnitServiceImpl(UnitsRepository repository, UnitMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseDto<UnitsDto> create(UnitsDto dto) {
        Optional<Units> store = repository.findFirstByName(dto.getName());
        if(!store.isEmpty()){
            return ResponseDto.<UnitsDto>builder()
                    .status(HttpStatus.OK.value())
                    .message(AppStatusMessages.DUPLICATE_ERROR)
                    .code(AppStatusCodes.DUPLICATE_ERROR_CODE)
                    .success(true)
                    .build();
        }
        Units newunits = mapper.toEntity(dto);
        repository.save(newunits);
        return ResponseDto.<UnitsDto>builder()
                .message(AppStatusMessages.OK)
                .code(AppStatusCodes.OK_CODE)
                .success(true)
                .data(mapper.toDto(newunits))
                .status(HttpStatus.OK.value())
                .build();
    }

    @Override
    public ResponseDto<Void> delete(Long id) {
        Optional<Units> active = repository.findFirstByIdAndActive(id, (short) 1);
        if(active.isEmpty()){
            return ResponseDto.<Void>builder()
                    .status(HttpStatus.OK.value())
                    .code(AppStatusCodes.OK_CODE)
                    .success(true)
                    .message(AppStatusMessages.NOT_FOUND)
                    .build();
        }
        Units delunits = active.get();
        delunits.setActive((short) 0);
        repository.save(delunits);
        return ResponseDto.<Void>builder()
                .message(AppStatusMessages.OK)
                .code(AppStatusCodes.OK_CODE)
                .success(true)
                .status(HttpStatus.OK.value())
                .build();
    }

    @Override
    public ResponseDto<UnitsDto> update(UnitsDto dto) {
        if(dto.id == null){
            return ResponseDto.<UnitsDto>builder()
                    .status(HttpStatus.OK.value())
                    .success(true)
                    .message(AppStatusMessages.NULL_VALUE)
                    .code(AppStatusCodes.OK_CODE)
                    .build();
        }
        Optional<Units> unitOptional = repository.findFirstByIdAndActive(dto.id, (short) 1);
        if (unitOptional.isEmpty()){
            return ResponseDto.<UnitsDto>builder()
                    .status(HttpStatus.OK.value())
                    .success(true)
                    .code(AppStatusCodes.NOT_FOUND_ERROR_CODE)
                    .message(AppStatusMessages.NOT_FOUND)
                    .build();

        }
        Units units = unitOptional.get();
        if (dto.getName() != null) {
            units.setName(dto.getName());
        } if (dto.getShortName() != null){
            units.setShortName(dto.getShortName());
        }
        return ResponseDto.<UnitsDto>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .code(AppStatusCodes.OK_CODE)
                .message(AppStatusMessages.OK)
                .data(mapper.toDto(units))
                .build();
    }

    @Override
    public ResponseDto<List<UnitsDto>> getAll() {
        return ResponseDto.<List<UnitsDto>>builder()
                .success(true)
                .message(AppStatusMessages.OK)
                .code(AppStatusCodes.OK_CODE)
                .data(repository.findAllByActive((short) 1).stream()
                        .map(u -> mapper.toDto(u))
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public ResponseDto<UnitsDto> getById(Long id) {
        if(id == null){
            return ResponseDto.<UnitsDto>builder()
                    .status(HttpStatus.OK.value())
                    .success(true)
                    .message(AppStatusMessages.NULL_VALUE)
                    .code(AppStatusCodes.OK_CODE)
                    .build();
        }
        Optional<Units> byId = repository.findById(id);
        if(byId.isEmpty()){
            return ResponseDto.<UnitsDto>builder()
                    .status(HttpStatus.OK.value())
                    .success(true)
                    .code(AppStatusCodes.NOT_FOUND_ERROR_CODE)
                    .message(AppStatusMessages.NOT_FOUND)
                    .build();
        }
        Units unit = byId.get();
        return ResponseDto.<UnitsDto>builder()
                .status(HttpStatus.OK.value())
                .success(true)
                .message(AppStatusMessages.OK)
                .code(AppStatusCodes.OK_CODE)
                .data(mapper.toDto(unit))
                .build();
    }

}
