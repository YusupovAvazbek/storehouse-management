package uz.nt.storehouse.mapper.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.nt.storehouse.dto.product.CategoryDto;
import uz.nt.storehouse.entity.product.Category;
import uz.nt.storehouse.mapper.base.AbstractMapper;
@Mapper(componentModel = "spring")
public interface CategoryMapper extends AbstractMapper<Category, CategoryDto> {
}
