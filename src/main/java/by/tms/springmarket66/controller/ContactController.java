package by.tms.springmarket66.controller;

import by.tms.springmarket66.dto.EditContactDto;
import by.tms.springmarket66.entity.User;
import by.tms.springmarket66.mapper.Converter;
import by.tms.springmarket66.service.ContactService;
import by.tms.springmarket66.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/contact")
public class ContactController {
    private final UserService userService;

    private final ContactService contactService;

    private final Converter converter;

    public ContactController(UserService userService, ContactService contactService, Converter converter) {
        this.userService = userService;
        this.contactService = contactService;
        this.converter = converter;
    }
    @GetMapping("/new")
    public String showFormForNewContact(Model model){
        EditContactDto editContactDto = new EditContactDto();
        editContactDto.setType(contactService.getAllTypeOfContacts());
        model.addAttribute("contact", editContactDto);
        return "contact/new";
    }

    @PostMapping("/new/{id}")
    public String create(@Valid @ModelAttribute("contact") EditContactDto editContactDto,
                         @PathVariable ("id") Long id,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "contact/new";
        }
        User user = converter.editContactToEntity(editContactDto);
        user.setId(id);
        contactService.updateContactByIdUser(user);
        return "shop/home";
    }

}
