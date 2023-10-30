package by.tms.springmarket66.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Contacts")
@ToString
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Type> type;

    private String contact;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User ownerContacts;
}
