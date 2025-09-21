package bootcamp.edu.crm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Setter
@Getter
public class UserEntity {

    /**
     * Primary key for the User table.
     * - @Id marks it as PK
     * - @Column(name = "user_id") sets column name
     * - @GeneratedValue(strategy = GenerationType.IDENTITY) means auto-increment
     */
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String name;
    private String email;

    /**
     * One-to-One mapping with ProfileEntity.
     *
     * cascade = {PERSIST, REMOVE, MERGE}
     *   - PERSIST → save User also saves Profile
     *   - REMOVE → delete User also deletes Profile
     *   - MERGE → update User also updates Profile
     *
     * orphanRemoval = true
     *   - If profile is set to null or replaced, old profile is deleted automatically.
     *
     * @JoinColumn(name = "profile_id")
     *   - Foreign key column in 'user' table pointing to 'profile.id'
     *
     * @JsonManagedReference
     *   - Jackson annotation to handle infinite recursion (parent side).
     */
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, orphanRemoval = true)
    @JsonManagedReference
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;
}
