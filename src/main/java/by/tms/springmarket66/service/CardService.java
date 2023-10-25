package by.tms.springmarket66.service;

import by.tms.springmarket66.dao.CardDao;
import by.tms.springmarket66.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired
    private CardDao cardDao;

    public void create(Card card){
        cardDao.save(card);
    }
}
