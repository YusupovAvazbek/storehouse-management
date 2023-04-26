package uz.nt.storehouse.mapper.base;

import org.mapstruct.Mapper;
import uz.nt.storehouse.repository.base.BaseRepository;

public interface AbstractMapper <E, D> extends BaseMapper {
    D toDto(E entity);
    E toEntity(D dto);
}
