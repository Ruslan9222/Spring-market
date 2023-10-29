package by.tms.springmarket66.service;

import by.tms.springmarket66.dao.CartDao;
import by.tms.springmarket66.entity.CartOfGoods;
import by.tms.springmarket66.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartOfGoodsService {

    private final CartDao cartDao;

    public CartOfGoodsService(CartDao cartDao) {
        this.cartDao = cartDao;
    }
    public List<Goods> findAll() {
        return this.cartDao.findAll();
    }
    public Goods findById(Long id){
        return this.cartDao.findById(id);
    }


}
