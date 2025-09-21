package bootcamp.edu.crm.repositary;


import bootcamp.edu.crm.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositary extends CrudRepository<UserEntity , Integer> {
}
