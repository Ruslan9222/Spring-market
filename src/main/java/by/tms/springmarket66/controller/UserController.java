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

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "user/home";
    }

    @GetMapping("/new")
    public String showFormForNewUser(Model model) {
        CreateUserDto createUserDto = new CreateUserDto();
        createUserDto.setRoles(roleService.getAllRoles());
        model.addAttribute("user", createUserDto);
        return "user/new";
    }

    @GetMapping("/login")
    public String showFormForLogin(Model model) {
        model.addAttribute("user", new LoginUserDto());
        return "user/login";
    }
    @GetMapping("/{id}/viewUser")
        public String showFormForUserInfo(Model model,@PathVariable("id") Long id){
        User user = userService.getUserAllInfoById(id);
        model.addAttribute("user", user);
        return "user/info";
    }

    @GetMapping("{email}/edit")
    public String showFormForUpdate(Model model, @PathVariable("email") String email) {
        EditProfileDto editProfileDto = converter.editProfileToDto(userService.getUserByEmail(email));
        model.addAttribute("user", editProfileDto);
        return "user/editProfile";
    }

    @GetMapping("/{email}/delete")
    public String showFormForDelete(Model model,
                                    @PathVariable("email") String email) {
        EditProfileDto editProfileDto = converter.editProfileToDto(userService.getUserByEmail(email));
        model.addAttribute("user", editProfileDto);
        return "user/delete";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") LoginUserDto loginUserDto,
                        BindingResult bindingResult,
                        HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "user/login";
        }
        User user = converter.loginUserToEntity(loginUserDto);
        session.setAttribute("currentUser", userService.getUserByEmail(user.getEmail()));
        System.out.println(userService.getUserByEmail(user.getEmail()));
        return "shop/home";
    }

    @PostMapping("/new")
    public String create(@Valid @ModelAttribute("user") CreateUserDto createUserDto,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/new";
        }
        userService.save(converter.createUserToEntity(createUserDto));
        return "user/home";
    }

    @PatchMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute("user") EditProfileDto editProfileDto,
                         @PathVariable("id") Long id,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/editProfile";
        }
        userService.updateUserById(id, converter.editUserToEntity(editProfileDto));
        return "shop/home";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, HttpSession session) {
        userService.deleteById(id);
        session.invalidate();
        return "user/home";
    }
}
