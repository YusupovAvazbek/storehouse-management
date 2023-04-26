package uz.nt.storehouse.service.store;

import uz.nt.storehouse.dto.store.StoreDto;
import uz.nt.storehouse.mapper.store.StoreMapper;
import uz.nt.storehouse.repository.store.StoreRepository;
import uz.nt.storehouse.response.ResponseDto;
import uz.nt.storehouse.service.base.AbstractService;

public class StoreServiceImpl extends AbstractService <
        StoreRepository,
        StoreMapper> implements StoreService{
    protected StoreServiceImpl(StoreRepository repository, StoreMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseDto<StoreDto> create(StoreDto dto) {
        return null;
    }

    @Override
    public ResponseDto<Void> delete(Long id) {
        return null;
    }

    @Override
    public ResponseDto<StoreDto> update(StoreDto dto) {
        return null;
    }
}
