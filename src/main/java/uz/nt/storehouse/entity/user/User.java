package uz.nt.storehouse.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.nt.storehouse.entity.base.Auditable;
import uz.nt.storehouse.entity.base.BaseEntity;
import uz.nt.storehouse.entity.store.Store;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends Auditable {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String password;
    private String role;
}
