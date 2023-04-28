package uz.nt.storehouse.rest.product;

import org.springframework.web.bind.annotation.*;
import uz.nt.storehouse.dto.product.UnitsDto;
import uz.nt.storehouse.dto.store.StoreDto;
import uz.nt.storehouse.response.ResponseDto;
import uz.nt.storehouse.rest.base.AbstractResources;
import uz.nt.storehouse.service.product.unit.UnitServiceImpl;

import java.util.List;

@RestController
@RequestMapping("api/unit")
public class UnitResources extends AbstractResources<UnitServiceImpl> {
    public UnitResources(UnitServiceImpl service) {
        super(service);
    }

    @GetMapping("get-all-units")
    public ResponseDto<List<UnitsDto>> getAllUsers(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseDto<UnitsDto> getById(@PathVariable Long id){
        return service.getById(id);
    }
    @PostMapping
    public ResponseDto<UnitsDto> create(@RequestBody UnitsDto userDto){
        return service.create(userDto);
    }
    @PatchMapping("update")
    public ResponseDto<UnitsDto> update(@RequestBody UnitsDto userDto){
        return service.update(userDto);
    }
    @DeleteMapping()
    public ResponseDto<Void> delete(@RequestParam Long id){
        return service.delete(id);
    }

}
