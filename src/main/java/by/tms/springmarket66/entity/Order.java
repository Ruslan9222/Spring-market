package by.tms.springmarket66.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "orders")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_username")
    private User user;

    private String address;

    private LocalDate date;
}
