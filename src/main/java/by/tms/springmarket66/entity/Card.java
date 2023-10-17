package by.tms.springmarket66.entity;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "users_username")
    private User user;

    private Integer number;

    private String name;

    private Integer cvv;
}
