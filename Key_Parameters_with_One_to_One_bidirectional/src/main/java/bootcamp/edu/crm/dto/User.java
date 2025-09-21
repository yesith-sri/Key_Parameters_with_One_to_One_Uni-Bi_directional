package bootcamp.edu.crm.dto;

import lombok.Data;

@Data
public class User {

    private Integer id ;
    private String name;
    private String email;
    private ProfileDto profileDto;

}
