package by.tms.springmarket66.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Table(name = "cards")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User ownerCard;

    private Integer number;

    private String name;

    private Integer cvv;
}
