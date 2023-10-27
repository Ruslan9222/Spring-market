package by.tms.springmarket66.controller;

import by.tms.springmarket66.entity.Card;
import by.tms.springmarket66.entity.User;
import by.tms.springmarket66.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/card")
public class CardController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CardService cardService;

    @GetMapping
    public String card() {
        return "card";
    }

    @PostMapping
    public String order(Card card, HttpSession httpSession) {
        User user = (User) request.getSession().getAttribute("user");
        cardService.create(card);
        return "card";
    }
}
