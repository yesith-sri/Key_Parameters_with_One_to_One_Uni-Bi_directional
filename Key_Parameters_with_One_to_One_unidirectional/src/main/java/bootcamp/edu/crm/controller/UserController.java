package bootcamp.edu.crm.controller;

import bootcamp.edu.crm.dto.User;
import bootcamp.edu.crm.entity.UserEntity;
import bootcamp.edu.crm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v2")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserEntity> create(@RequestBody Map<String, User> userMap) {
        ResponseEntity responseEntity = userService.create(userMap);
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Integer id, @RequestBody UserEntity user) {
        return userService.updateUser(id, user);
    }

}
