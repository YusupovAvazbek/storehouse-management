package uz.nt.storehouse.service.base;

import uz.nt.storehouse.mapper.base.BaseMapper;
import uz.nt.storehouse.repository.base.BaseRepository;

public abstract class AbstractService<
        R extends BaseRepository,
        M extends BaseMapper
        > implements BaseService{
    protected R repository;
    protected M mapper;
    protected AbstractService(R repository, M mapper){
        this.repository = repository;
        this.mapper = mapper;
    }
}
