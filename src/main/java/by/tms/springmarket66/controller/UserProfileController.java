package by.tms.springmarket66.controller;

import by.tms.springmarket66.dao.UserDao;
import by.tms.springmarket66.entity.User;
import by.tms.springmarket66.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/profile")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;
    private UserDao userDao;
    @GetMapping("/create")
    public String createGet(){
        return "profile";
    }
    @PostMapping("/create")
    public String createPost(User user,
                             HttpSession session){
        userProfileService.create(user);

        session.setAttribute("user", user);
        return "updateProfile";
    }
    @GetMapping("/update")
    public String updateGet(User user,
                            HttpSession session,
                            Model model){
        User userById = (User) session.getAttribute("user");
        model.addAttribute("user",userById);
        return "updateProfile";
    }
    @PostMapping("/update")
    public String updatePost(User user,
                             HttpSession session){
        userProfileService.updateUser(user);
        session.setAttribute("user",user);
        return "updateProfile";
    }
}
