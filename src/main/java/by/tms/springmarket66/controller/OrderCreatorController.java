package by.tms.springmarket66.controller;

import by.tms.springmarket66.dao.OrderDao;
import by.tms.springmarket66.dao.UserDao;
import by.tms.springmarket66.entity.Order;
import by.tms.springmarket66.entity.User;
import by.tms.springmarket66.service.OrderCreateService;
import by.tms.springmarket66.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
@RequestMapping("/order")
public class OrderCreatorController {


    @Autowired
    private OrderCreateService orderCreateService;
    @GetMapping
    public String order() {
        return "order";
    }

    @PostMapping
    public String order(Order order) {
        LocalDate localDate = LocalDate.now();
        order.setDate(localDate);
        orderCreateService.create(order);
        return "order";
    }
}
