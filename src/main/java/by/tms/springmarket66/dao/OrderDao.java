package by.tms.springmarket66.dao;

import by.tms.springmarket66.entity.Order;
import by.tms.springmarket66.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
@Transactional
public class OrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Order order){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(order);
    }
}
