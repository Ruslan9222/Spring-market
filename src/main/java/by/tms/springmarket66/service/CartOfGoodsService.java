package by.tms.springmarket66.service;

import by.tms.springmarket66.dao.CartDao;
import by.tms.springmarket66.entity.Goods;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartOfGoodsService {

    private final CartDao cartDao;

    public CartOfGoodsService(CartDao cartDao) {
        this.cartDao = cartDao;
    }
    public List<Goods> findAllGoods() {
        return this.cartDao.findAll();
    }

    public Goods findGoodsById(Long id) {
        return  this.cartDao.findById(id);
//        for (Goods goods : this.cartDao.findById(id)) {
//            if (goods.getId().equals(id)) {
//                return cartDao.findById(id);
//            }
//        }
//        return null;
    }


}
