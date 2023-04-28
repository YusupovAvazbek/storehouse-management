package uz.nt.storehouse.service.product.product;

import uz.nt.storehouse.dto.product.ProductDto;
import uz.nt.storehouse.mapper.product.ProductMapper;
import uz.nt.storehouse.repository.product.ProductRepository;
import uz.nt.storehouse.response.ResponseDto;
import uz.nt.storehouse.service.base.AbstractService;
import uz.nt.storehouse.service.base.AssistCrudService;

import java.util.List;

public class ProductServiceImpl extends AbstractService<
        ProductRepository,
        ProductMapper
        > implements ProductService, AssistCrudService<ProductDto, Long> {
    protected ProductServiceImpl(ProductRepository repository, ProductMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseDto<ProductDto> create(ProductDto dto) {
        return null;
    }

    @Override
    public ResponseDto<Void> delete(Long id) {
        return null;
    }

    @Override
    public ResponseDto<ProductDto> update(ProductDto dto) {
        return null;
    }

    @Override
    public ResponseDto<List<ProductDto>> getAll() {
        return null;
    }

    @Override
    public ResponseDto<ProductDto> getById(Long id) {
        return null;
    }
}
