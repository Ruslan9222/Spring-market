package by.tms.springmarket66.mapper;

import by.tms.springmarket66.dto.EditContactDto;
import by.tms.springmarket66.dto.CreateUserDto;

import by.tms.springmarket66.dto.EditProfileDto;
import by.tms.springmarket66.dto.LoginUserDto;
import by.tms.springmarket66.entity.Contact;
import by.tms.springmarket66.entity.Role;
import by.tms.springmarket66.entity.Type;
import by.tms.springmarket66.entity.User;
import by.tms.springmarket66.service.ContactService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Converter {
    private final ContactService contactService;

    public Converter(ContactService contactService) {
        this.contactService = contactService;
    }

    public User loginUserToEntity(LoginUserDto loginUserDto){
        User user = new User();
        user.setEmail(loginUserDto.getEmail());
        user.setPassword(loginUserDto.getPassword());
        return user;
    }

    public User createUserToEntity(CreateUserDto createUserDto) {
        Set<Role> roles = createUserDto.
                getRoles().
                stream().
                map(Role::valueOf).
                collect(Collectors.toUnmodifiableSet());
        return new User(createUserDto.getEmail(), createUserDto.getPassword(), roles);
    }

    public EditProfileDto editProfileToDto(User user) {
        EditProfileDto editProfileDto = new EditProfileDto();
        editProfileDto.setEmail(user.getEmail());
        editProfileDto.setFirstName(user.getFirstName());
        editProfileDto.setLastName(user.getLastName());
        editProfileDto.setPassword(user.getPassword());
        editProfileDto.setUsername(user.getUsername());
        return editProfileDto;
    }

    public User editUserToEntity(EditProfileDto editProfileDto){
        User user = new User();
        user.setFirstName(editProfileDto.getFirstName());
        user.setLastName(editProfileDto.getLastName());
        user.setUsername(editProfileDto.getUsername());
        user.setPassword(editProfileDto.getPassword());
        return user;
    }




    public EditContactDto editContactToDto(User user){
        EditContactDto editContactDto = new EditContactDto();
        editContactDto.setType(contactService.getAllTypeOfContacts());
        editContactDto.setContact(user.getContacts().
                stream().
                map(Contact::getContact).
                toString());
        return editContactDto;
    }

    public User editContactToEntity(EditContactDto editContactDto){
        User user =  new User();
        Contact contact = new Contact();
        List<Contact> contacts = new ArrayList<>();
        Set<Type> types = editContactDto.getType().
                stream().
                map(Type::valueOf).
                collect(Collectors.toUnmodifiableSet());
        contact.setType(types);
        contact.setContact(editContactDto.getContact());
        contact.setOwnerContacts(user);
        contacts.add(contact);
        user.setContacts(contacts);

        return user;
    }
}
