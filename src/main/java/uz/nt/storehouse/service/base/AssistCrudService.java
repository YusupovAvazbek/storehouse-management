package uz.nt.storehouse.service.base;

import uz.nt.storehouse.dto.base.BaseDto;
import uz.nt.storehouse.response.ResponseDto;

import java.io.Serializable;
import java.util.List;
public interface AssistCrudService <D extends BaseDto, K extends Serializable>{
    ResponseDto<List<D>> getAll();
    ResponseDto<D> getById(K id);
}
