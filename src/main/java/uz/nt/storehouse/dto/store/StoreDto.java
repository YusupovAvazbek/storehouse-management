package uz.nt.storehouse.dto.store;

import lombok.Getter;
import lombok.Setter;
import uz.nt.storehouse.dto.base.BaseDto;
import uz.nt.storehouse.dto.product.ProductDto;

import java.util.List;

@Getter
@Setter
public class StoreDto extends BaseDto {
    private String name;
    private List<ProductDto> products;
    public StoreDto(Long id, String name, List<ProductDto> products){
        super(id);
        this.name = name;
        this.products = products;
    }
}
