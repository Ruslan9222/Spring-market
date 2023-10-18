package by.tms.springmarket66.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String firstName;
        private String lastName;
        private String username;
        private String email;
        private String password;
        @ManyToMany(cascade = {CascadeType.MERGE})
        @JoinTable(name = "users_roles",
                joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
        private Set<Role> roles = new HashSet<>();
}
