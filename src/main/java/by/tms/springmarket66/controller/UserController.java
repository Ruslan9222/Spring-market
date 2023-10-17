package by.tms.springmarket66.controller;

import by.tms.springmarket66.entity.User;
import by.tms.springmarket66.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public String show(Model model){
        model.addAttribute("users", userService.viewAllUsers());
        return "user/list";
    }

    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("user", new User());
        return "user/new";
    }
    @GetMapping("/{id}")
    public String setRoleById(@PathVariable (id) long id,Model model){

    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user,
                             HttpSession session){
        userService.create(user);
        session.setAttribute("user", user);
        return "user/user";
    }


}
