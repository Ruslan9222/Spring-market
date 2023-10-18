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
        @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
        @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"))
        @Enumerated(EnumType.STRING)
        private Set<Role> roles = new HashSet<>();
}
