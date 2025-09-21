package bootcamp.edu.crm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "profile")
@Setter
@Getter
public class ProfileEntity {

    /**
     * Primary key for Profile table.
     * - @Id marks this as PK
     * - @Column(name = "profile_id") sets the DB column name
     * - @GeneratedValue(strategy = GenerationType.IDENTITY) → auto-increment
     */
    @Id
    @Column(name = "profile_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Profile picture URL field */
    private String profilepicurl;

    /**
     * One-to-One relationship with UserEntity (inverse side).
     *
     * mappedBy = "profile"
     *   - Refers to the 'profile' field in UserEntity.
     *   - Means UserEntity owns the relationship (with FK).
     *
     * fetch = FetchType.LAZY
     *   - Profile.user is not fetched immediately from DB.
     *   - It loads only when explicitly accessed (better performance).
     *
     * @JsonBackReference
     *   - Paired with @JsonManagedReference in UserEntity.
     *   - Prevents infinite recursion in JSON serialization (this side is ignored).
     *
     * (Alternative: @JsonIgnore could also be used here if you don’t want to return 'user' at all.)
     */
    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY)
    @JsonBackReference
    private UserEntity user;
}
