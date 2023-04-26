package uz.nt.storehouse.dto.product;

import lombok.Getter;
import lombok.Setter;
import uz.nt.storehouse.dto.base.BaseDto;

@Getter
@Setter
public class ProductDto extends BaseDto {
    private String name;
    private String description;
    private Double price;
    private CategoryDto category;
    private UnitsDto unit;
    public ProductDto(Long id, String name, String description, Double price, CategoryDto category, UnitsDto unit ){
        super(id);
        this.category = category;
        this.unit = unit;
        this.description = description;
        this.price = price;
    }
}
