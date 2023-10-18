package by.tms.springmarket66.controller;

import by.tms.springmarket66.entity.User;
import by.tms.springmarket66.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("user", userService.viewAllUsers());
        return "user/info";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", userService.findUserById(id));
        return "user/info";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.findUserById(id));
        return "user/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") long id) {
        userService.updateUser(id, user);
        return "user/info";
    }


    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "user/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.create(user);
        return "user/info";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable("id") int id, User user) {
        userService.setSeller(id, user);
        return "redirect:/user";
    }
}
