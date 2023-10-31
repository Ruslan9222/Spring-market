package by.tms.springmarket66.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String photoItem;
    private String name;
    private String description;
    private Integer quantity;
    private Double price;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinTable(name = "categories",
            joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Category category;


    public Item(String photoItem, String name, Category category, String description, Integer quantity, Double price) {
        this.photoItem = photoItem;
        this.name = name;
        this.category = category;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }
}
