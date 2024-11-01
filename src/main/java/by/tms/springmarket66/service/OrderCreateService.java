package by.tms.springmarket66.service;

import by.tms.springmarket66.dao.OrderDao;
import by.tms.springmarket66.dao.UserDao;
import by.tms.springmarket66.entity.Order;
import by.tms.springmarket66.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderCreateService {
    @Autowired
    private OrderDao orderDao;

    public void create(Order order){
        orderDao.save(order);
    }





}
