package uz.nt.storehouse.service.product.category;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.nt.storehouse.dto.product.CategoryDto;
import uz.nt.storehouse.dto.product.UnitsDto;
import uz.nt.storehouse.entity.product.Category;
import uz.nt.storehouse.entity.product.Units;
import uz.nt.storehouse.mapper.product.CategoryMapper;
import uz.nt.storehouse.mapper.validator.AppStatusCodes;
import uz.nt.storehouse.mapper.validator.AppStatusMessages;
import uz.nt.storehouse.repository.product.CategoryRepository;
import uz.nt.storehouse.response.ResponseDto;
import uz.nt.storehouse.service.base.AbstractService;
import uz.nt.storehouse.service.base.AssistCrudService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl extends AbstractService<
        CategoryRepository,
        CategoryMapper
        > implements CategoryService, AssistCrudService<CategoryDto, Long> {
    protected CategoryServiceImpl(CategoryRepository repository, CategoryMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseDto<CategoryDto> create(CategoryDto dto) {
        Optional<Category> category = repository.findFirstByName(dto.getName());
        if(!category.isEmpty()){
            return ResponseDto.<CategoryDto>builder()
                    .status(HttpStatus.OK.value())
                    .message(AppStatusMessages.DUPLICATE_ERROR)
                    .code(AppStatusCodes.DUPLICATE_ERROR_CODE)
                    .success(true)
                    .build();
        }
        Category newcategory = mapper.toEntity(dto);
        repository.save(newcategory);
        return ResponseDto.<CategoryDto>builder()
                .message(AppStatusMessages.OK)
                .code(AppStatusCodes.OK_CODE)
                .success(true)
                .data(mapper.toDto(newcategory))
                .status(HttpStatus.OK.value())
                .build();
    }

    @Override
    public ResponseDto<Void> delete(Long id) {
        Optional<Category> active = repository.findFirstByIdAndActive(id, (short) 1);
        if(active.isEmpty()){
            return ResponseDto.<Void>builder()
                    .status(HttpStatus.OK.value())
                    .code(AppStatusCodes.OK_CODE)
                    .success(true)
                    .message(AppStatusMessages.NOT_FOUND)
                    .build();
        }
        Category delcategory = active.get();
        delcategory.setActive((short) 0);
        repository.save(delcategory);
        return ResponseDto.<Void>builder()
                .message(AppStatusMessages.OK)
                .code(AppStatusCodes.OK_CODE)
                .success(true)
                .status(HttpStatus.OK.value())
                .build();
    }

    @Override
    public ResponseDto<CategoryDto> update(CategoryDto dto) {
        return null;
    }

    @Override
    public ResponseDto<List<CategoryDto>> getAll() {
        return null;
    }

    @Override
    public ResponseDto<CategoryDto> getById(Long id) {
        return null;
    }
}
