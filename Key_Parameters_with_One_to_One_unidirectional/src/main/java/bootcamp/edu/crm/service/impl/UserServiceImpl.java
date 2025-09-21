package bootcamp.edu.crm.service.impl;

import bootcamp.edu.crm.dto.User;
import bootcamp.edu.crm.entity.ProfileEntity;
import bootcamp.edu.crm.entity.UserEntity;
import bootcamp.edu.crm.repositary.ProfileRepositary;
import bootcamp.edu.crm.repositary.UserRepositary;
import bootcamp.edu.crm.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ProfileRepositary profileRepositary;
    private final UserRepositary userRepositary;
    private final ObjectMapper objectMapper;

    @Override
    public ResponseEntity create(Map<String, User> userMap) {
        User userProfileDetils = userMap.get("userProfileDetils");

        UserEntity userEntity = new UserEntity();
        userEntity.setName(userProfileDetils.getName());
        userEntity.setEmail(userProfileDetils.getEmail());

        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setProfilepicurl(userProfileDetils.getProfileDto().getProfilepicurl());

        userEntity.setProfile(profileEntity);

        userEntity = userRepositary.save(userEntity);
        return ResponseEntity.ok(userEntity);
    }

    @Override
    public ResponseEntity<String> deleteUser(Integer id) {
        if (!userRepositary.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found with id: " + id);
        }
        userRepositary.deleteById(id); // Cascade delete triggers here
        return ResponseEntity.ok("User and related Profile deleted successfully");
    }

    @Transactional
    public ResponseEntity<UserEntity> updateUser(Integer id, UserEntity newUserData) {
        UserEntity user = userRepositary.findById(id).orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        // Update simple fields
        user.setName(newUserData.getName());
        user.setEmail(newUserData.getEmail());

        // Update or replace profile
        if (newUserData.getProfile() != null) {
            if (user.getProfile() != null) {
                user.getProfile().setProfilepicurl(newUserData.getProfile().getProfilepicurl());
            } else {
                user.setProfile(newUserData.getProfile());
            }
        }

        UserEntity updatedUser = userRepositary.save(user);
        return ResponseEntity.ok(updatedUser);
    }

}
