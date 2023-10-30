package by.tms.springmarket66.mapper;

import by.tms.springmarket66.dto.CartOfGoodsDTO;
import by.tms.springmarket66.entity.CartOfGoods;
import by.tms.springmarket66.service.ContactService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    private final CartMapper cartMapper;

    public CartMapper(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    public CartOfGoods createCartOfGoodsToCartOfGoods(@NotNull CartOfGoodsDTO cartOfGoodsDTO){
        return new CartOfGoods(0L,cartOfGoodsDTO.getQuantity(),cartOfGoodsDTO.getGoodsList());
    }
}
