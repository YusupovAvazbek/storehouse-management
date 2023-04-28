package uz.nt.storehouse.mapper.store;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.nt.storehouse.dto.store.StoreDto;
import uz.nt.storehouse.entity.store.Store;
import uz.nt.storehouse.mapper.base.AbstractMapper;
@Component
@Mapper(componentModel = "spring")
public interface StoreMapper extends AbstractMapper<Store, StoreDto> {
}
