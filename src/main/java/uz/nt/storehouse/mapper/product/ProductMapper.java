package uz.nt.storehouse.mapper.product;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.nt.storehouse.dto.product.ProductDto;
import uz.nt.storehouse.entity.product.Product;
import uz.nt.storehouse.mapper.base.AbstractMapper;
@Component
@Mapper(componentModel = "spring")
public interface  ProductMapper extends AbstractMapper<Product, ProductDto> {
}
