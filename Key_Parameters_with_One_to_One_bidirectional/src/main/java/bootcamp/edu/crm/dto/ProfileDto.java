package bootcamp.edu.crm.dto;

import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
public class ProfileDto {

    private Integer id;
    private String profilepicurl;

}
