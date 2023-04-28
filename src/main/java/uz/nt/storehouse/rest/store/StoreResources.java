package uz.nt.storehouse.rest.store;

import org.springframework.web.bind.annotation.*;
import uz.nt.storehouse.dto.store.StoreDto;
import uz.nt.storehouse.response.ResponseDto;
import uz.nt.storehouse.rest.base.AbstractResources;
import uz.nt.storehouse.service.store.StoreServiceImpl;

import java.util.List;

@RestController
@RequestMapping("api/store")
public class StoreResources extends AbstractResources<StoreServiceImpl> {
    public StoreResources(StoreServiceImpl service) {
        super(service);
    }
    @GetMapping("get-all-stores")
    public ResponseDto<List<StoreDto>> getAllUsers(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseDto<StoreDto> getById(@PathVariable Long id){
        return service.getById(id);
    }
    @PostMapping
    public ResponseDto<StoreDto> create(@RequestBody StoreDto userDto){
        return service.create(userDto);
    }
    @PatchMapping("update")
    public ResponseDto<StoreDto> update(@RequestBody StoreDto userDto){
        return service.update(userDto);
    }
    @DeleteMapping()
    public ResponseDto<Void> delete(@RequestParam Long id){
        return service.delete(id);
    }

}
