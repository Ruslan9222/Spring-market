package by.tms.springmarket66.dto;

import by.tms.springmarket66.entity.Goods;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartOfGoodsDTO {
    private Long id;
    private int quantity;

    private List<Goods> goodsList;



}
