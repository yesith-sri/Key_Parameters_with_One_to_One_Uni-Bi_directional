package bootcamp.edu.crm.service;

import bootcamp.edu.crm.dto.User;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
    ResponseEntity create(Map<String, User> userMap);

}
