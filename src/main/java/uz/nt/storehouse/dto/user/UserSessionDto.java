package uz.nt.storehouse.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class UserSessionDto {
    private UUID uuid;
    private String userInfo;
}
