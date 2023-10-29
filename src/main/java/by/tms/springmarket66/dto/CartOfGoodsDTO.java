package by.tms.springmarket66.dto;

import by.tms.springmarket66.entity.Goods;
import by.tms.springmarket66.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartOfGoodsDTO {
    private Long count;

    private List<Goods> goodsList;

    private List<User> user;

}
