package uz.nt.storehouse.dto.base;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDto implements BaseGenericDto {
    public Long id;
}
