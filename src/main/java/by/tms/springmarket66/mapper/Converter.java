package by.tms.springmarket66.mapper;

import by.tms.springmarket66.dto.CartOfGoodsDTO;
import by.tms.springmarket66.dto.ContactDto;
import by.tms.springmarket66.dto.CreateUserDto;

import by.tms.springmarket66.dto.EditDto;
import by.tms.springmarket66.entity.Goods;
import by.tms.springmarket66.entity.Role;
import by.tms.springmarket66.entity.User;
import by.tms.springmarket66.service.ContactService;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Converter {
    private final ContactService contactService;

    public Converter(ContactService contactService) {
        this.contactService = contactService;
    }

    public User toEntity(CreateUserDto createUserDto) {
        Set<Role> roles = createUserDto.
                getRoles().
                stream().
                map(Role::valueOf).
                collect(Collectors.toUnmodifiableSet());
        return new User(createUserDto.getUsername(), createUserDto.getEmail(), createUserDto.getPassword(), roles);
    }

    public EditDto toDto(User user) {
        EditDto editDto = new EditDto();
        editDto.setFirstName(user.getFirstName());
        editDto.setLastName(user.getLastName());
        editDto.setPassword(user.getPassword());
        editDto.setUsername(user.getUsername());
        editDto.setEmail(user.getEmail());
        ContactDto contactDto = new ContactDto();
        contactDto.setType(contactService.getAllTypeOfContacts());
        editDto.setContacts(List.of(contactDto));
        editDto.setRoles(new HashSet<>());
        editDto.setRoles(user.getRoles().
                stream().
                map(String::valueOf).
                collect(Collectors.toSet()));
        return editDto;
    }
    public Goods goods(CartOfGoodsDTO cartOfGoodsDTO){
        return new Goods();
    }
}
