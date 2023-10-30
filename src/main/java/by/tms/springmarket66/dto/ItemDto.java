package by.tms.springmarket66.dto;

import by.tms.springmarket66.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    @NotEmpty
    @NotNull
    private String photoItem;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    @NotEmpty
    private Integer quantity;

    @NotNull
    @NotEmpty
    private Double price;

    @NotNull
    @NotEmpty
    private Category category;


}
