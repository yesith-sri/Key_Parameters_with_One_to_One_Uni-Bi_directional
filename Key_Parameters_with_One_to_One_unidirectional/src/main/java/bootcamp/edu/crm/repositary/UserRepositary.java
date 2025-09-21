package bootcamp.edu.crm.repositary;

import bootcamp.edu.crm.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositary extends JpaRepository<UserEntity, Integer> {


}
