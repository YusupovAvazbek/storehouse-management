package uz.nt.storehouse.service.product.category;

import uz.nt.storehouse.dto.product.CategoryDto;
import uz.nt.storehouse.mapper.product.CategoryMapper;
import uz.nt.storehouse.repository.product.CategoryRepository;
import uz.nt.storehouse.response.ResponseDto;
import uz.nt.storehouse.service.base.AbstractService;

public class CategoryServiceImpl extends AbstractService<
        CategoryRepository,
        CategoryMapper
        > implements CategoryService {
    protected CategoryServiceImpl(CategoryRepository repository, CategoryMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseDto<CategoryDto> create(CategoryDto dto) {
        return null;
    }

    @Override
    public ResponseDto<Void> delete(Long id) {
        return null;
    }

    @Override
    public ResponseDto<CategoryDto> update(CategoryDto dto) {
        return null;
    }
}
