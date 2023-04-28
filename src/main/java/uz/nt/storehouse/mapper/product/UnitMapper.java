package uz.nt.storehouse.mapper.product;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.nt.storehouse.dto.product.UnitsDto;
import uz.nt.storehouse.entity.product.Units;
import uz.nt.storehouse.mapper.base.AbstractMapper;
@Component
@Mapper(componentModel = "spring")
public interface UnitMapper extends AbstractMapper<Units, UnitsDto> {
}
