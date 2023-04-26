package uz.nt.storehouse.dto.user;

import lombok.*;
import uz.nt.storehouse.dto.base.BaseDto;

@Getter
@Setter
public class UserDto extends BaseDto {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String role;
    @Builder(builderMethodName = "childBuilder")
    public UserDto(Long id, String fullName, String email, String phoneNumber, String role) {
        super(id);
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }
}
