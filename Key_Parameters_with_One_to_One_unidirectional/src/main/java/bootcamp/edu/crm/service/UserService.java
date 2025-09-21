package bootcamp.edu.crm.service;

import bootcamp.edu.crm.dto.User;
import bootcamp.edu.crm.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
    ResponseEntity create(Map<String, User> userMap);

    ResponseEntity<String> deleteUser(Integer id);

    ResponseEntity<UserEntity> updateUser(Integer id, UserEntity user);
}
