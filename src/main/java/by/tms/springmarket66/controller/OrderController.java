package by.tms.springmarket66.controller;

import by.tms.springmarket66.entity.Order;
import by.tms.springmarket66.entity.User;
import by.tms.springmarket66.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private OrderService orderService;

    @GetMapping
    public String order() {
        return "order";
    }

    @PostMapping
    public String order(Order order, HttpSession httpSession) {
        User user = (User) request.getSession().getAttribute("user");
        LocalDateTime localDate = LocalDateTime.now();
        order.setDate(localDate);
        orderService.create(order);
        return "order";
    }
}
