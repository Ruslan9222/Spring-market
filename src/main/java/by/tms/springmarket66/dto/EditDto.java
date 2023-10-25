package by.tms.springmarket66.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditDto {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private List<ContactDto> contacts;
    private Set<String> roles;
}
