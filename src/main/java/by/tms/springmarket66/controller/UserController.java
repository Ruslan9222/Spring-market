package by.tms.springmarket66.controller;

import by.tms.springmarket66.dto.CreateUserDto;
import by.tms.springmarket66.dto.EditProfileDto;
import by.tms.springmarket66.dto.LoginUserDto;
import by.tms.springmarket66.entity.User;
import by.tms.springmarket66.mapper.Converter;
import by.tms.springmarket66.service.RoleService;
import by.tms.springmarket66.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final Converter converter;
    private final RoleService roleService;

    public UserController(UserService userService, Converter converter, RoleService roleService) {
        this.userService = userService;
        this.converter = converter;
        this.roleService = roleService;
    }

    @GetMapping
    public String getHomePage() {
        return "user/home";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        CreateUserDto createUserDto = new CreateUserDto();
        createUserDto.setRoles(roleService.getAllRoles());
        model.addAttribute("user", createUserDto);
        return "user/new";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new LoginUserDto());
        return "user/login";
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        model.addAttribute("user", new EditProfileDto());
        return "user/editProfile";
    }

    @GetMapping("/{email}/delete")
    public String deleteGet(Model model,
                            @PathVariable("email") String email) {
        model.addAttribute("user", userService.findUserByEmail(email));
        return "user/delete";
    }

    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute("user") LoginUserDto loginUserDto,
                            BindingResult bindingResult,
                            HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "user/login";
        }
        User user = converter.loginUserToEntity(loginUserDto);
        session.setAttribute("currentUser", userService.findUserByEmail(user.getEmail()));
        System.out.println(userService.findUserByEmail(user.getEmail()));

        return "shop/home";
    }

    @PostMapping("/new")
    public String createUser(@Valid @ModelAttribute("user") CreateUserDto createUserDto,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/new";
        }
        userService.create(converter.createUserToEntity(createUserDto));
        return "user/home";
    }

    @PatchMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute("user") EditProfileDto editProfileDto,
                         @PathVariable("id") Long id,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "user/editProfile";
        }
        userService.updateUserById(id,converter.editUserToEntity(editProfileDto));
        return "shop/home";
    }

    @PatchMapping("/{email}/delete")                      //????????????????????
    public String delete(@PathVariable("email") String email) {
        userService.deleteUser(email);
        return "user/home";
    }
}
