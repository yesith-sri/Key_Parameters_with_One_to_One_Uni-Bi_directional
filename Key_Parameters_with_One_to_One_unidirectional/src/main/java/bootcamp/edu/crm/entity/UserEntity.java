package bootcamp.edu.crm.entity;

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
     * - @Id → Marks as the primary key
     * - @Column(name = "user_id") → Column name in DB will be user_id
     * - @GeneratedValue(strategy = GenerationType.IDENTITY) → Auto-increment (MySQL/Postgres style)
     */
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    /** Simple field for storing user's name */
    private String name;

    /** Simple field for storing user's email */
    private String email;

    /**
     * One-to-One relationship with ProfileEntity.
     *
     * cascade = {PERSIST, REMOVE, MERGE}
     *   - PERSIST → Saving a new User also saves its Profile.
     *   - REMOVE → Deleting a User also deletes its Profile.
     *   - MERGE → Updating a User also updates its Profile.
     *
     * orphanRemoval = true
     *   - If profile is set to null or replaced, the old Profile will be deleted from DB.
     *
     * @JoinColumn(name = "profile_id")
     *   - Adds a foreign key column 'profile_id' in the User table.
     *   - This makes UserEntity the owning side of the relationship.
     */
    @OneToOne(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE},
            orphanRemoval = true
    )
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;
}

