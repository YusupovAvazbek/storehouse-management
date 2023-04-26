package uz.nt.storehouse.dto.product;

import lombok.Getter;
import lombok.Setter;
import uz.nt.storehouse.dto.base.BaseDto;
@Getter
@Setter
public class CategoryDto extends BaseDto {
    private String name;
    private CategoryDto parentCategory;
    public CategoryDto(Long id, String name,CategoryDto categoryDto){
        super(id);
        this.parentCategory = categoryDto;
        this.name = name;
    }
}
