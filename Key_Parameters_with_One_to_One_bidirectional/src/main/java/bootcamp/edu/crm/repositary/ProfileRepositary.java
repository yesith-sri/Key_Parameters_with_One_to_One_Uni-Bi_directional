package bootcamp.edu.crm.repositary;


import bootcamp.edu.crm.entity.ProfileEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepositary extends CrudRepository<ProfileEntity, Integer> {
}
