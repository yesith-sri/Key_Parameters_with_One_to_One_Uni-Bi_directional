package bootcamp.edu.crm.service.Impl;


import bootcamp.edu.crm.dto.User;
import bootcamp.edu.crm.entity.ProfileEntity;
import bootcamp.edu.crm.entity.UserEntity;
import bootcamp.edu.crm.repositary.ProfileRepositary;
import bootcamp.edu.crm.repositary.UserRepositary;
import bootcamp.edu.crm.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
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

        userEntity.setProfile(profileEntity);  /** don't forget to put this in bidirectional with cascade parameters */
        profileEntity.setUser(userEntity);   /** don't forget to put this in bidirectional with cascade parameters */
                                            /** Saves both due to cascade  */
        userEntity = userRepositary.save(userEntity);
        return ResponseEntity.ok(userEntity);
    }

}
