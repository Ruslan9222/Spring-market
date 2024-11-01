package by.tms.springmarket66.dao;

import by.tms.springmarket66.entity.Card;
import by.tms.springmarket66.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class CardDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Card card) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(card);
    }








}
