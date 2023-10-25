package by.tms.springmarket66.dao;

import by.tms.springmarket66.entity.Order;
import by.tms.springmarket66.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class OrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Order order) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(order);
    }








}
