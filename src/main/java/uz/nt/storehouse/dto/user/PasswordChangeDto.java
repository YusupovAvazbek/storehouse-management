package uz.nt.storehouse.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PasswordChangeDto {
    private String oldPassword;
    private String newPassword;
}
