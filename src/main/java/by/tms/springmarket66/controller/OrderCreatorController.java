package by.tms.springmarket66.controller;

import by.tms.springmarket66.entity.Order;
import by.tms.springmarket66.entity.User;
import by.tms.springmarket66.service.OrderCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/order")
public class OrderCreatorController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private OrderCreateService orderCreateService;

    @GetMapping
    public String order() {
        return "order";
    }

    @PostMapping
    public String order(Order order) {
        User user = (User) request.getSession().getAttribute("user");
        LocalDateTime localDate = LocalDateTime.now();
        order.setDate(localDate);
        orderCreateService.create(order);
        return "order";
    }
}
