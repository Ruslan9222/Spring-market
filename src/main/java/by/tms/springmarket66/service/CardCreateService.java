package by.tms.springmarket66.service;

import by.tms.springmarket66.dao.CardDao;
import by.tms.springmarket66.dao.OrderDao;
import by.tms.springmarket66.entity.Card;
import by.tms.springmarket66.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardCreateService {
    @Autowired
    private CardDao cardDao;

    public void create(Card card){
        cardDao.save(card);
    }
}
