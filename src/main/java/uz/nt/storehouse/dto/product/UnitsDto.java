package uz.nt.storehouse.dto.product;

import lombok.Getter;
import lombok.Setter;
import uz.nt.storehouse.dto.base.BaseDto;

@Getter
@Setter
public class UnitsDto extends BaseDto {
    private String name;
    private String shortName;
    public UnitsDto(Long id, String name, String shortName){
        super(id);
        this.name = name;
        this.shortName = shortName;
    }
}
