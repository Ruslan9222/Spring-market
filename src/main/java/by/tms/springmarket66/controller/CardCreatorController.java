package by.tms.springmarket66.controller;

import by.tms.springmarket66.entity.Card;
import by.tms.springmarket66.entity.Order;
import by.tms.springmarket66.entity.User;
import by.tms.springmarket66.service.CardCreateService;
import by.tms.springmarket66.service.OrderCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/order")
public class CardCreatorController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CardCreateService cardCreateService;

    @GetMapping
    public String card() {
        return "card";
    }

    @PostMapping
    public String order(Card card) {
        User user = (User) request.getSession().getAttribute("user");
        cardCreateService.create(card);
        return "card";
    }
}
