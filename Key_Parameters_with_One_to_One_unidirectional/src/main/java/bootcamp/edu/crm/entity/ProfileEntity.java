package bootcamp.edu.crm.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "profile")
@Setter
@Getter
public class ProfileEntity {

    /**
     * Primary key for the Profile table.
     * - @Id → Marks as primary key
     * - @Column(name = "profile_id") → Column name is profile_id
     * - @GeneratedValue(strategy = GenerationType.IDENTITY) → Auto-increment (DB generates ID)
     */
    @Id
    @Column(name = "profile_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Field to store the profile picture URL */
    private String profilepicurl;
}
