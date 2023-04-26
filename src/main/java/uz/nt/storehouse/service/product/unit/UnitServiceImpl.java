package uz.nt.storehouse.service.product.unit;

import uz.nt.storehouse.dto.product.UnitsDto;
import uz.nt.storehouse.mapper.product.UnitMapper;
import uz.nt.storehouse.repository.product.UnitsRepository;
import uz.nt.storehouse.response.ResponseDto;
import uz.nt.storehouse.service.base.AbstractService;

public class UnitServiceImpl extends AbstractService<
        UnitsRepository,
        UnitMapper
        > implements UnitService {
    protected UnitServiceImpl(UnitsRepository repository, UnitMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseDto<UnitsDto> create(UnitsDto dto) {
        return null;
    }

    @Override
    public ResponseDto<Void> delete(Long id) {
        return null;
    }

    @Override
    public ResponseDto<UnitsDto> update(UnitsDto dto) {
        return null;
    }
}
