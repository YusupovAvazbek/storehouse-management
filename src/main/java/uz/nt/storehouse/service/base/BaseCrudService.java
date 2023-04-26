package uz.nt.storehouse.service.base;

import uz.nt.storehouse.dto.base.BaseDto;
import uz.nt.storehouse.response.ResponseDto;

import java.io.Serializable;

public interface BaseCrudService<
        D extends BaseDto,
        K extends Serializable
        >{
    ResponseDto<D> create(D dto);
    ResponseDto<Void> delete(K id);
    ResponseDto<D> update(D dto);
}
