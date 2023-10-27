package by.tms.springmarket66.entity;

import lombok.*;
import org.hibernate.validator.constraints.pl.NIP;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.*;

@Table(name = "users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    @NotNull
    private String username;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Contact> contacts;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User(String username, String email, String password, Set<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
