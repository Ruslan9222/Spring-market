package by.tms.springmarket66.entity;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
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
    private String username;


    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "ownerContacts")
    private List<Contact> contacts;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerCard")
    private List<Card> CreditCard;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerOrders")
    private List<Order> orders;

    public User(String email, String password, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
