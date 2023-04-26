package uz.nt.storehouse.rest.base;

import lombok.RequiredArgsConstructor;
import uz.nt.storehouse.service.base.BaseService;
@RequiredArgsConstructor
public class AbstractResources <S extends BaseService> {
    protected final S service;
}
