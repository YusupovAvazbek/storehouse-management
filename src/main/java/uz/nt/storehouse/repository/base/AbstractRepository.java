package uz.nt.storehouse.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import uz.nt.storehouse.entity.base.BaseEntity;

import java.io.Serializable;
@NoRepositoryBean
public interface AbstractRepository <
        E extends BaseEntity,
        K extends Serializable>
        extends JpaRepository<E, K>, BaseRepository{
}
