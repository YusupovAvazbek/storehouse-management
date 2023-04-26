package uz.nt.storehouse.entity.organization;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.nt.storehouse.entity.base.Auditable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Organization extends Auditable {
    private String name;
    private String phoneNumber;
    private String email;
}
