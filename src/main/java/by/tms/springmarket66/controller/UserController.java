package by.tms.springmarket66.controller;

import by.tms.springmarket66.dto.CreateDto;
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
    public String getHomePage(HttpSession session,
                              Model model) {

        CreateDto currentUser = (CreateDto) session.getAttribute("currentUser");
        model.addAttribute("user", currentUser);
        return "user/home";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        CreateDto createDto = new CreateDto();
        createDto.setRoles(roleService.getAllRoles());
        model.addAttribute("user", createDto);
        return "user/new";
    }

    @GetMapping("/{email}")
    public String show(@PathVariable("email") String email, Model model) {
        model.addAttribute("user", userService.findUserByEmail(email));
        return "user/info";
    }

    @GetMapping("/{email}/edit")
    public String edit(Model model, @PathVariable("email") String email) {
        model.addAttribute("user", converter.toDto(userService.findUserByEmail(email)));
        return "user/edit";
    }

    @GetMapping("/{email}/delete")
    public String deleteGet(Model model,
                            @PathVariable("email") String email) {
        model.addAttribute("user", userService.findUserByEmail(email));
        return "user/delete";
    }

    @PostMapping()
    public String createUser(@Valid CreateDto createDto,
                             BindingResult bindingResult,
                             HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "user/new";
        }
        session.setAttribute("currentUser", converter.toEntity(createDto));
        userService.create(converter.toEntity(createDto));
        return "redirect:/home";
    }

    @PatchMapping("/{email}")
    public String update(@ModelAttribute("user") CreateDto createDto,
                         @PathVariable("email") String email) {
        userService.findUserByEmail(email);
        return "user/info";
    }

    @PatchMapping("/{email}/delete")                      //????????????????????
    public String delete(@PathVariable("email") String email) {
        userService.deleteUser(email);
        return "user/home";
    }
}
