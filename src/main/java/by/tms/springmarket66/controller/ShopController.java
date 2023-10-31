package by.tms.springmarket66.controller;

import by.tms.springmarket66.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/shop")
public class ShopController {
    @GetMapping("/home")
    public String info(Model model,
                       HttpSession session){
        User  user  = (User) session.getAttribute("currentUser");
        model.addAttribute("user",user);
        return "shop/home";
    }

}
