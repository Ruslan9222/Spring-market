package by.tms.springmarket66.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Contacts")
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
